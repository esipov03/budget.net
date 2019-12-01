//TODO export to json config                                                                                                                                                                                                       
var radius = 150;
var clockwiseLen = 10;
var processLen = 20;
var pad = radius+clockwiseLen+processLen;
var processPad = 2;
var numOfDays = 365;
var basicOpacity=0.5;
var backOpacity=0.2;
var line_len = 500;
var maxStage = 0;
var sellecterColor = '#0FFFFFFF';
//Рендерит у пользователя циферблат
function clockwise() {
    for (let i = 0; i < numOfDays; i++){
        let element = document.createElementNS('http://www.w3.org/2000/svg', 'use');
        element.setAttribute('href', '#clockline');
        element.setAttribute('transform', 'rotate('+i*360/numOfDays+') translate('+radius+')');
        document.getElementById("svg-socket").append(element);
    }
}  
/**
 * Создает дугу процесса
 *  @param {number} dayStart День начало процесса (0-365)
 *  @param {number} dayEnd День окончания процесса (0-365)
 *  @param {color} color Цвет процесса на графике
 *  @param {number} stage Номер кольца, на котором расположится процесс
**/
function createProcessLine(dayStart, dayEnd, color, stage) {
    let element = document.createElementNS('http://www.w3.org/2000/svg', 'path');
    element.dataset.id = Math.floor(Math.random() * (+10000 - +1000) + +1000);
    let fullPad = pad+stage*(processLen+processPad);
    let arg = 0;
    if(dayEnd-dayStart > numOfDays/2) arg = 1;
    let x1 = getXbyCorner(dayStart * 360/numOfDays, fullPad);
    let y1 = -getYbyCorner(dayStart * 360/numOfDays, fullPad);
    let x2 = getXbyCorner(dayEnd * 360/numOfDays, fullPad);
    let y2 = -getYbyCorner(dayEnd * 360/numOfDays, fullPad);
    
    if(stage > maxStage) maxStage = stage;
    element.setAttribute('d', 'M '+x1+', '+y1+' A '+fullPad+' '+fullPad+' 0 '+arg+' 0 '+x2+', '+y2);
    element.setAttribute('stroke', color);
    element.setAttribute('class', 'process-path')
    element.setAttribute('stroke-width', processLen);
    element.setAttribute('fill', 'none');
    element.setAttribute('opacity', basicOpacity);

    element.classList.add("btn");
    document.getElementById("svg-socket").append(element);  
}
function createFill(stage, color) {
    let element = document.createElementNS('http://www.w3.org/2000/svg', 'path');
    let fullPad = pad+(stage-1)*(processLen+processPad);
    let x1 = getXbyCorner(0, fullPad);
    let y1 = -getYbyCorner(0, fullPad);
    let x2 = getXbyCorner(180, fullPad);
    let y2 = -getYbyCorner(180, fullPad);
    document.getElementById("svg-socket").append(element);

    element.setAttribute('d', 'M '+x1+', '+y1+' A '+fullPad+' '+fullPad+' 0 1 0 '+x2+', '+y2+' A '+fullPad+' '+fullPad+' 0 0 0 '+x1+', '+y1);
    element.setAttribute('stroke', color);
    element.setAttribute('class', 'process-path');
    element.setAttribute('stroke-width', processLen);
    element.setAttribute('fill', 'none');
    element.setAttribute('opacity', backOpacity);
}
/**
 * Функия визуализации сдачи отчета
 * @param {number} day День, в который произойдет сдача отчета  
 * @param {number} stageBy От какой организации
 * @param {number} stageTo К какой организации
 * @param {color*} color цвет на диаграмме
 */
function createTransaction(day, stageBy, stageTo, color, identificator) {
    let element = document.createElementNS('http://www.w3.org/2000/svg', 'line');
    let padStart;
    let padEnd;
    let padCircle;
    console.log(day+' '+stageBy+' '+stageTo+' '+color);
    if(stageTo > stageBy) {
        padStart = radius+clockwiseLen*2+stageBy*(processLen+processPad)+processLen/2;
        padEnd = radius+clockwiseLen*2+stageTo*(processLen+processPad)-processPad-processLen/2;
        padCircle = padStart;
    }
    else {
        padStart = radius+clockwiseLen*2+stageTo*(processLen+processPad)-(processLen+processPad)/2;
        padEnd = radius+clockwiseLen*2+stageBy*(processLen+processPad)+processLen/2;
        padCircle = padEnd;
    }
    let x1 = getXbyCorner(day * 360/numOfDays, padStart);
    let y1 = -getYbyCorner(day * 360/numOfDays, padStart);
    let x2 = getXbyCorner(day * 360/numOfDays, padEnd);
    let y2 = -getYbyCorner(day * 360/numOfDays, padEnd);
    let cx = getXbyCorner(day * 360/numOfDays, padCircle);
    let cy = -getYbyCorner(day * 360/numOfDays, padCircle);

    let circlePath = processLen/12;
    element.setAttribute('x1', x1);
    element.setAttribute('y1', y1);
    let circleElement1 = document.createElementNS('http://www.w3.org/2000/svg', 'circle');
    circleElement1.setAttribute('cx', cx);
    circleElement1.setAttribute('cy', cy);
    circleElement1.setAttribute('r', 4*circlePath);
    circleElement1.setAttribute('fill', color);
    let circleElement2 = document.createElementNS('http://www.w3.org/2000/svg', 'circle');
    circleElement2.setAttribute('cx', cx);
    circleElement2.setAttribute('cy', cy);
    circleElement2.setAttribute('r', 3*circlePath);
    circleElement2.setAttribute('fill', 'white');
    let circleElement3 = document.createElementNS('http://www.w3.org/2000/svg', 'circle');
    circleElement3.setAttribute('cx', cx);
    circleElement3.setAttribute('cy', cy);
    circleElement3.setAttribute('r', 2*circlePath);
    circleElement3.setAttribute('fill', color);
    document.getElementById("svg-socket").append(circleElement1);
    document.getElementById("svg-socket").append(circleElement2);
    document.getElementById("svg-socket").append(circleElement3);

    if(identificator != null) element.setAttribute('id', identificator);
    element.setAttribute('x2', x2);
    element.setAttribute('y2', y2);
    element.setAttribute('stroke', color);
    element.setAttribute('stroke-width', '1');
    element.setAttribute('opacity', basicOpacity);
    document.getElementById("svg-socket").append(element);

}
/**
 * Создает чекбокс организации в меню справа
 * @param {*} enterprise Обьект организации
 */
function createCheckBlock(enterprise) {
    const m = document.getElementById('companyList');
    //for (let i = 0; i<100; i++) {
        const block = document.createElement('div');

        block.innerHTML = `
                        <div class="inputGroup">
                            <input id="${enterprise.id}" class="input_box" type="checkbox"/>
                            <label for="${enterprise.id}">
                            <span class="company-name">${enterprise.name}</span>
                            <span class="dopInfo">

                            <span class="dop-info-item">
                            <span class="ico red"></span>
                            <span class="dop-info-info">Исполнено: `+(numOfProcWithStat(enterprise.processes, "success"))+`</span>
                            </span>

                            <span class="dop-info-item">
                            <span class="ico red"></span>
                            <span class="dop-info-info">Не исполнено: `+(numOfProcWithStat(enterprise.processes, "lost"))+`</span>
                            </span>
                            <span class="dop-info-item">
                            <span class="ico red"></span>
                            <span class="dop-info-info">Ожидает: `+(numOfProcWithStat(enterprise.processes, "wait"))+`</span>
                            </span>

                            </span>
                            </label>
                        </div>
                `;
        m.appendChild(block);
    //}
}
function numOfProcWithStat(array, stat) {
    let i = 0;
    array.forEach(element =>{
        if(element.status == stat)
            i++;
    });
    return i;
}
/**
 * Функция создания сегмента выделения
 * @param {number} dayStart День начала выборки
 * @param {number} dayEnd День конца выборки
 */
function sellectSegment(dayStart, dayEnd) {
    console.log(dayStart, dayEnd);
        if(document.getElementById('select-path-line') != null)
            document.getElementById('select-path-line').remove();
        let element = document.createElementNS('http://www.w3.org/2000/svg', 'path');
        let fullPad = 1500;
        let arg = 0;
        console.log(dayStart * 360/numOfDays +' '+ dayEnd * 360/numOfDays +' '+ Math.abs(dayStart * 360/numOfDays - dayEnd * 360/numOfDays));   
        if(dayStart < dayEnd)
            if(Math.abs(dayStart * 360/numOfDays - dayEnd * 360/numOfDays) < 180) arg = 1;
            else arg = 0;
        else
            if(Math.abs(dayStart * 360/numOfDays - dayEnd * 360/numOfDays) > 180) arg = 0;
            else arg = 1;
        let x1 = getXbyCorner(dayStart * 360/numOfDays, fullPad);
        let y1 = -getYbyCorner(dayStart * 360/numOfDays, fullPad);
        let x2 = getXbyCorner(dayEnd * 360/numOfDays, fullPad);
        let y2 = -getYbyCorner(dayEnd * 360/numOfDays, fullPad);
            
        element.setAttribute('d', 'M '+x1+', '+y1+' A '+fullPad+' '+fullPad+' 0 '+arg+' 0 '+x2+', '+y2);
        element.setAttribute('stroke', sellecterColor);
        element.setAttribute('stroke-width', fullPad*2);
        element.setAttribute('fill', 'none');
        element.setAttribute('opacity', 0.2);
        element.setAttribute('id', 'select-path-line')
        document.getElementById("svg-socket").append(element)
}
/// utils
/**
 * Функция, выдающая цвета
 */
var curColor = 0;
function getColor() {
    let retColor = [
        '#fc34ff',
        '#3aff35',
        '#4260ff',
        '#a2cc29',
        '#6600CC',
        '#0000FF',
        '#00CCFF',
        '#00CC99',
        '#00FF00',
        '#CCFF33',
        '#999999'
    ][curColor];
    curColor++;
    if(curColor == 10) curColor = 0;
    return retColor;
}
//Возвращает длину вектора A(x1,y1)B(x2,y2)
function getLenOfVector(x1, y1, x2, y2){
    return Math.abs(Math.sqrt((x2-x1)**2+(y2-y1)**2));
}
//Возвращает X точки на окружности радиусом radius по углу corner
function getXbyCorner(corner, radius){
    return radius*Math.cos(degToRad(corner));
}
//Возвращает Y точки на окружности радиусом radius по углу corner
function getYbyCorner(corner, radius){
    return radius*Math.sin(degToRad(corner));
}
//Преобразует градусы в радианы
function degToRad(corner) {
    return (Math.PI * corner) / 180;
}
//Возвращает номер дня в году
function dayInYear(day,mounth,year = 2019) {
    mounth = parseInt(mounth);
    mounth--;
    var nullDate = new Date(year,0,1);

    var inputDate = new Date(year,mounth,day);
    var mils = inputDate.getTime()-nullDate.getTime();
    var days =  mils/(24*3600000);
    return Math.floor(days+1);
}
//Возвращает номер дня в году, по дате в виде "ДД.ММ.ГГГГ"
function parseDate(string){
    if(string == NaN) return 0;
    let arr = string.split('-');
    return dayInYear(arr[2], arr[1], arr[0]);
}

/// Функциональный модуль
var stageList = [];
function getKeyById(id) {
    let i = 0;
    for(let element in stageList){
        console.log(element);
        if(element == id) return i;
        i++;
    }
    return i;
}
/**
 * 
 * @param {Process} process Процесс, который необходимо визуализировать
 * @param {number} i Номер кольца размещения
 * @param {Enterprise} enterprise Организация, исполняющая процесс
 */
function createProcess(process, i, enterprise) {
    let color = enterprise.color;
    createProcessLine(parseDate(process.dateCreate), parseDate(process.dateEnd), color, i);
    if(process.founder != -1)
        if(Array.isArray(process.founder)){
            process.founder.forEach(element => {
                if(getKeyById(element) == -1) return;
                createTransaction(parseDate(process.dateEnd), i, getKeyById(element), color);
            });
        } else
        if(getKeyById(process.founder) != -1)
            createTransaction(parseDate(process.dateEnd), i, getKeyById(process.founder), color);
}
/**
 * 
 * @param {object} data Распаршеный JSON ответ с сервера о том, что требуется визуализировать
 */
function createView(data) {
    clockwise();
    data.forEach(enterprise => {
        enterprise.color = getColor();
        stageList.push(enterprise);
        createFill(stageList.indexOf(enterprise)+1, enterprise.color);
    });
    data.forEach((enterprise, key) => {
        createCheckBlock(enterprise);
        enterprise.processes.forEach(process => {
            createProcess(process, key, enterprise);
        });
    });
}
showEnterpriseByParent(0);
//Запрос данных сервера. подробнее в main.js
//let data = '[{"id":1,"name":"Департамент финансов города Москвы","processes":[{"id":0,"founder":4,"dateCreate":"2019-01-01","dateEnd":"2019-06-25","nextProcesses":[4],"previousProcesses":[2]},{"id":0,"founder":2,"dateCreate":"2019-01-01","dateEnd":"2019-06-05","nextProcesses":[2],"previousProcesses":[]},{"id":0,"founder":2,"dateCreate":"2019-01-01","dateEnd":"2019-08-05","nextProcesses":[9],"previousProcesses":[7]}]},{"id":2,"name":"Главные администраторы доходов бюджета города и главные администраторы источников финансирования дефицита бюджета Москвы","processes":[{"id":0,"founder":1,"dateCreate":"2019-01-01","dateEnd":"2019-06-15","nextProcesses":[3],"previousProcesses":[1]},{"id":0,"founder":1,"dateCreate":"2019-01-01","dateEnd":"2019-08-15","nextProcesses":[],"previousProcesses":[8]},{"id":0,"founder":1,"dateCreate":"2019-01-01","dateEnd":"2019-08-15","nextProcesses":[],"previousProcesses":[]}]},{"id":3,"name":"Департамент экономической политики и развития города Москвы","processes":[{"id":0,"founder":4,"dateCreate":"2019-01-01","dateEnd":"2019-07-01","nextProcesses":[5,6,7],"previousProcesses":[3]}]},{"id":4,"name":"Главные распорядители бюджетных средств","processes":[{"id":0,"founder":1,"dateCreate":"2019-01-01","dateEnd":"2019-07-10","nextProcesses":[],"previousProcesses":[4]},{"id":0,"founder":1,"dateCreate":"2019-01-01","dateEnd":"2019-07-10","nextProcesses":[],"previousProcesses":[4]},{"id":0,"founder":1,"dateCreate":"2019-01-01","dateEnd":"2019-07-10","nextProcesses":[8],"previousProcesses":[4]}]}]';
//createView(JSON.parse(data));
function showEnterpriseByParent(parentID) {
    ajax({
    // задается тип запрос
    type: 'GET', 
    url: 'http://localhost:8080/enterprise?parentId='+parentID,

    }, function (data) {
        createView(JSON.parse(data).body);

        setCompanyFunction();
    }, function (response, code) {
        setCompanyFunction();
        //alert("Нет соединения с сервером:\n"+code+': '+response);
    }, function (response, code) {
        // response - ответ серва, code - код
        // выполняется всегда после завешения запроса
    });
}
function getEnterpriseByParent(parentID){

}