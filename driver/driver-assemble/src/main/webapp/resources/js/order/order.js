function selectTime() {
    var select = document.getElementById("timechoose")

    //alert(grade);
    var grade;
    var s = $("#timechoose ").get(0).selectedIndex;
    if (s == 0) {
        grade = select.options[1].value;
    } else {
        grade = $('#timechoose  option:selected').val()
    }

    alert(grade);
}