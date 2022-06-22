/*
 * js实现checkbox模拟radio 并保留checkbox全取消
 */
function onlyselectone(num) {
    var cb1 = document.getElementById("cb1");
    var cb2 = document.getElementById("cb2");
    if(num==1){
        if(cb1.checked){
            cb2.checked = false;
        }
    }else{
        if (cb2.checked){
            cb1.checked = false;
        }
    }
}
