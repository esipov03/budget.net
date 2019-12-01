/**
 * Обработчик поиска по организациям.
 * Работет если len >= 1, скрывает все блоки, показывает те
 * что подходят по поисковому запросу
 */
document.getElementById('search').addEventListener('keyup', searcher);
function searcher(e) {
    const companys = document.getElementsByClassName('company-name');
    for (let i=0;i<companys.length; i++) {
        if (this.value.length >= 1) {
            companys[i].parentElement.parentElement.parentElement.style.display = 'none';
            if (companys[i].innerHTML.toLowerCase().indexOf(this.value.toLowerCase()) !== -1) {
                companys[i].parentElement.parentElement.
                    parentElement.style.display = 'block';
            }
        } else {
            companys[i].parentElement.parentElement.
                parentElement.style.display = 'block';
        }
    }
}

/**
 * Обрабатвыает изменение полей даты (начало-конец)
 * @type {null}
 */
let dStart = null, dEnd = null;
document.getElementById('date_from').addEventListener('change', dateFromHeader);
function dateFromHeader(e) {
    console.log(this.value);
    const day = this.value.split('-')[2];
    const month = this.value.split('-')[1];
    dStart = dayInYear(day, month, this.value.split('-')[0]);
    if (dEnd !== null)
        sellectSegment(dStart, dEnd);
}

document.getElementById('date_to').addEventListener('change', dateToHeader);
function dateToHeader(e) {
    console.log(this.value);
    const day = this.value.split('-')[2];
    const month = this.value.split('-')[1];
    dEnd = dayInYear(day, month, this.value.split('-')[0]);
    if (dStart !== null)
        sellectSegment(dStart, dEnd);
}


/**
 * Функция запросов на сервер
 * @param type - тип запроса
 * @param url - url
 * @param data - массив с параметрами
 * @param sync - асинхронен ли запрос
 * @param success - функция, вызываемая после успешного выполнения (200)
 * @param error - функция выполняемая после ошибки (!== 200)
 * @param always - функция выполняемая всегда
 **/
function ajax({
                  type = 'get',
                  url  = '/',
                  data = [],
                  sync = true
              }, success, error, always) {

    const formData = new FormData();
    for (param in data)
        formData.append(param, data[param]);

    const xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (always)
            always(xmlHttp.responseText, xmlHttp.status);
        if (xmlHttp.readyState < 4) {
            return false;
        } else if (xmlHttp.status !== 200) {
            if (error)
                error(xmlHttp.responseText, xmlHttp.status);
            return false;
        } else {
            if (success)
                success(xmlHttp.responseText);
        }
    };

    xmlHttp.open(type, url, sync);
    xmlHttp.send(formData);
}



// Пример
function ajaxExample() {
    ajax({
        type: 'post', // задается тип запрос
        url: 'localhost:8080/admin/path',
        data: {
            param1: 'data1',
            param2: 'data2'
        },
        sync: true
    }, function (data) {
        // data - ответ сервера
        // скрипт о успешном выполнении
    }, function (response, code) {
        // response - ответ сервера, code - возвращаемый код
        // скрипт о ошибке
    }, function (response, code) {
        // response - ответ серва, code - код
        // выполняется всегда после завешения запроса
    });
}

// задает всем компаниям event на change
function setCompanyFunction() {
    const inputList = document.getElementsByClassName('input_box');
    for (let i =0; i<inputList.length; i++)
        inputList[i].addEventListener('change', companyChange);
}
setCompanyFunction();

function companyChange() {
    if (this.checked) {
        if(isCheckedAll()) document.getElementById('allSelector').checked = true;
    } else {
        if (document.getElementById('allSelector').checked === true) document.getElementById('allSelector').checked = false;
    }
}

document.getElementById('allSelector').addEventListener('change', changeAll);

function changeAll() {
        const inputList = document.getElementsByClassName('input_box');
        for (let i=0;i<inputList.length;i++) {
            inputList[i].checked = this.checked;
        }
}
function isCheckedAll() {
    const inputList = document.getElementsByClassName('input_box');
    for (let i=0;i<inputList.length;i++)
        if (inputList[i].checked === false) return false;
    return true;
}