
var radius = 150;
var clockwiseLen = 10;
var processLen = 20;
var pad = radius+clockwiseLen+processLen;
var processPad = 2;
var numOfDays = 365;
var basicOpacity=0.5;
var line_len = 500;
var maxStage = 0;
var sellecterColor = '#0F5EC4CD';

function clockwise() {
    for (let i = 0; i < numOfDays; i++){
        let element = document.createElementNS('http://www.w3.org/2000/svg', 'use');
        element.setAttribute('href', '#clockline');
        element.setAttribute('transform', 'rotate('+i*360/numOfDays+') translate('+radius+')');
        document.getElementById("svg-socket").append(element);
    }
}
function createProcessLine(dayStart, dayEnd, color, stage) {
    let element = document.createElementNS('http://www.w3.org/2000/svg', 'path');
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
    element.setAttribute('stroke-width', processLen);
    element.setAttribute('fill', 'none');
    element.setAttribute('opacity', basicOpacity);
    document.getElementById("svg-socket").append(element);
}
function createTransaction(day, stageBy, stageTo, color) {
    let element = document.createElementNS('http://www.w3.org/2000/svg', 'line');
    let padStart;
    let padEnd;
    if(stageTo > stageBy) {
        padStart = stageBy*(processLen+processPad)+clockwiseLen+radius+processPad*2.5;
        padEnd = (stageTo+1)*(processPad+processLen)+clockwiseLen+radius+processPad*1.5;
    }
    else {
        padStart = stageTo*(processLen+processPad)+clockwiseLen+radius+processPad*2.5;
        padEnd = (stageBy+1)*(processPad+processLen)+clockwiseLen+radius+processPad*1.5;;
    }
    let x1 = getXbyCorner(day * 360/numOfDays, padStart);
    let y1 = -getYbyCorner(day * 360/numOfDays, padStart);
    let x2 = getXbyCorner(day * 360/numOfDays, padEnd);
    let y2 = -getYbyCorner(day * 360/numOfDays, padEnd);
    element.setAttribute('x1', x1);
    element.setAttribute('y1', y1);
    element.setAttribute('x2', x2);
    element.setAttribute('y2', y2);
    element.setAttribute('stroke', color);
    element.setAttribute('stroke-width', '1');
    element.setAttribute('opacity', basicOpacity);
    document.getElementById("svg-socket").append(element);

}
function createCheckBlock(enterprise) {
    const m = document.getElementById('companyList');
    //for (let i = 0; i<100; i++) {
        const block = document.createElement('div');
        block.innerHTML = `
                        <div class="inputGroup">
                            <input id="company-${enterprise.id}" class="input_box" type="checkbox"/>
                            <label for="company-${enterprise.id}">
                            <span class="company-name">${enterprise.name}</span>
                            <span class="dopInfo">

                            <span class="dop-info-item">
                            <span class="ico red"></span>
                            <span class="dop-info-info">Исполнено: ${enterprise.ready}</span>
                            </span>

                            <span class="dop-info-item">
                            <span class="ico red"></span>
                            <span class="dop-info-info">Не исполнено: ${enterprise.wait}</span>
                            </span>
                            <span class="dop-info-item">
                            <span class="ico red"></span>
                            <span class="dop-info-info">Ожидает: ${enterprise.in_prog}</span>
                            </span>

                            </span>
                            </label>
                        </div>
                `;
        m.appendChild(block);
    //}
}
function sellectSegment(dayStart, dayEnd) {
    let element = document.createElementNS('http://www.w3.org/2000/svg', 'path');
    let selectorPad = radius+clockwiseLen*2;
    let radiusOfCircle = selectorPad+(maxStage)*(processPad+processLen)/2;

    let x1 = getXbyCorner(dayStart * 360/numOfDays, radiusOfCircle);
    let y1 = -getYbyCorner(dayStart * 360/numOfDays, radiusOfCircle);
    let x2 = getXbyCorner(dayEnd * 360/numOfDays, radiusOfCircle);
    let y2 = -getYbyCorner(dayEnd * 360/numOfDays, radiusOfCircle);
    let arg = 0;
    if(dayEnd-dayStart > numOfDays/2) arg = 1;

    element.setAttribute('d', 'M '+x1+', '+y1+' A '+radiusOfCircle+' '+radiusOfCircle+' 0 '+arg+' 0 '+x2+', '+y2);
    element.setAttribute('stroke', sellecterColor);
    element.setAttribute('stroke-width', radiusOfCircle);
    element.setAttribute('fill', 'none');
    element.setAttribute('opacity', basicOpacity);
    document.getElementById("svg-socket").append(element);
}
/// Random generator block
function getRandomMM(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}
/// utils
var curColor = 0;
function getColor() {
    let retColor = [
        '#A52959',
        '#5D016D',
        '#519600',
        '#A62300',
        '#FFC300',
        '#04859D',
        '#FF4040',
        '#300571',
        '#3D9200',
        '#FF7800',
    ][curColor];
    curColor++;
    if(curColor == 10) curColor = 0;
    return retColor;
}
function getLenOfVector(x1, y1, x2, y2){
    return Math.abs(Math.sqrt((x2-x1)**2+(y2-y1)**2));
}
function getXbyCorner(corner, fullPad){
    return fullPad*Math.cos(degToRad(corner));
}
function getYbyCorner(corner, fullPad){
    return fullPad*Math.sin(degToRad(corner));
}
function degToRad(corner) {
    return (Math.PI * corner) / 180;
}
function dayInYear(day,mounth,year = 2019) {
    mounth = parseInt(mounth);
    mounth--;
    var nullDate = new Date(year,0,1);

    var inputDate = new Date(year,mounth,day);
    var mils = inputDate.getTime()-nullDate.getTime();
    var days =  mils/(24*3600000);
    return Math.floor(days+1);
}
function parseDate(string){
    let arr = string.split('.');
    return dayInYear(arr[0], arr[1], arr[2]);
}
/// Функциональный модуль

function createProcess(process, i) {
    createProcessLine(parseDate(process.date_create), parseDate(process.date_end), getColor(), i);

}
function createView(data) {
    clockwise();
    let i = 0;
    data.forEach(enterprise => {
        createCheckBlock(enterprise);
        enterprise.processes.forEach(process => {
            createProcess(process, i, enterprise);
        });
        i++;
    });

}
let data =
    [
        {
            id: "1",
            name: "Urbat.Tech",
            in_prog: "13",
            wait: '3',
            ready:'28',
            processes: [
                {
                    id: '1',
                    finder: '2',
                    date_create: '13.05.2019',
                    date_end: '20.05.2019',
                    prev_proc: '-1',
                    next_proc: '2'
                },
                {
                    id: '4',
                    finder: '2',
                    date_create: '19.07.2019',
                    date_end: '23.07.2019',
                    prev_proc: '3',
                    next_proc: '5'
                },
                {
                    id: '6',
                    finder: '3',
                    date_create: '27.07.2019',
                    date_end: '30.07.2019',
                    prev_proc: '5',
                    next_proc: '7'
                }
            ]
        },
        {
            id: "2",
            name: "bydget.net",
            in_prog: '3',
            wait: '0',
            ready:'28',
            processes: [
                {
                    id: '2',
                    finder: '3',
                    date_create: '21.05.2019',
                    date_end: '05.06.2019',
                    prev_proc: '1',
                    next_proc: '3'
                },
                {
                    id: '5',
                    finder: '1',
                    date_create: '23.07.2019',
                    date_end: '26.07.2019',
                    prev_proc: '4',
                    next_proc: '6'
                }
            ]
        },
        {
            id: "3",
            name: "overmind",
            in_prog: '4',
            wait: '43',
            ready:'28',
            processes: [
                {
                    id: '3',
                    finder: '1',
                    date_create: '06.06.2019',
                    date_end: '19.07.2019',
                    prev_proc: '2',
                    next_proc: '4'
                },
                {
                    id: '7',
                    finder: '-1',
                    date_create: '01.08.2019',
                    date_end: '09.08.2019',
                    prev_proc: '6',
                    next_proc: '-1'
                }
            ]
        }
    ];
createView(data);