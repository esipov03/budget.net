var date_from= document.getElementById('date_from');
var date_to= document.getElementById('date_to');
var now = new Date();
year = now.getFullYear();
dEnd = dayInYear(now.getDate(),now.getMonth()+1,year);
dStart =dayInYear(1,1,year);
setNow();
setFirst();
InitilizeRoudAngle();

sellectSegment(dEnd,dStart);

function setNow() {

    var month = (now.getMonth() + 1).toString().length === 1 ? '0' + (now.getMonth() + 1).toString() : now.getMonth() + 1;
    var date = now.getDate().toString().length === 1 ? '0'         + (now.getDate()).toString()      : now.getDate();
    var formattedDateTime = year + '-' + month + '-' + date;

    date_to.value = (formattedDateTime);

}
// аЁбаЁааЁта ТАа аа аа ба аа ба ТА а аа ТАаЁтЁа ТАа ТЛаЁаа аа ба т а ва ТАаЁтаЁтЙ - "а ва ТАаЁтаЁтЙ" а ба ба ва ТА
function setFirst()
{
    var formattedDateTime = year+"-01-01";
    date_from.value = (formattedDateTime);
    // dFirst = dayInYear(day,mounth,year);
}
//аВбаБаОб аНаОаВаОаГаО аГаОаДаА
function InitilizeRoudAngle()
{
    numOfDays = dayInYear(31,12,year);

}
