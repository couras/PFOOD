/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('body').on('keydown', 'input, select, textarea', function(e) {
var self = $(this)
  , form = self.parents('form:eq(0)')
  , focusable
  , next
  , prev
  ;

if (e.shiftKey) {
 if (e.keyCode == 13) {
     focusable =   form.find('input,a,select,button,textarea').filter(':visible');
     prev = focusable.eq(focusable.index(this)-1); 

     if (prev.length) {
        prev.focus();
     } else {
//        form.submit();
    }
  }
}
  else
if (e.keyCode == 13) {
    focusable = form.find('input,a,select,button,textarea').filter(':visible');
    next = focusable.eq(focusable.index(this)+1);
    if (next.length) {
        next.focus();
    } else {
        e.target.click();
//        form.submit(); 
    }
    return false;
}
});

function myfocus(id) {$(id).focus();}  

//$(function() {
//    var action;
//    $(".number-spinner a").mousedown(function () {
//        btn = $(this);
//        input = btn.closest('.number-spinner').find('input');
//        btn.closest('.number-spinner').find('a').prop("disabled", false);
//
//    	if (btn.attr('data-dir') == 'up') {
//            action = setInterval(function(){
//                if ( input.attr('max') == undefined || parseInt(input.val()) < parseInt(input.attr('max')) ) {
//                    input.val(parseInt(input.val())+1);
//                }else{
//                    btn.prop("disabled", true);
//                    clearInterval(action);
//                }
//            } ,200);
//    	} else {
//            action = setInterval(function(){
//                if ( input.attr('min') == undefined || parseInt(input.val()) > parseInt(input.attr('min')) ) {
//                    input.val(parseInt(input.val())-1);
//                }else{
//                    btn.prop("disabled", true);
//                    clearInterval(action);
//                }
//            } , 300);
//    	}
//    }).mouseup(function(){
//        clearInterval(action);
//    });
//});

function spninnerbtnactive() {
    $(".number-spinner a").click( function () {
        btn = $(this);
        input = btn.closest('.number-spinner').find('input');
        btn.closest('.number-spinner').find('a').prop("disabled", false);

        if (btn.attr('data-dir') == 'up') {

            if (input.attr('max') == undefined || parseInt(input.val()) < parseInt(input.attr('max'))) {
                input.val(parseInt(input.val()) + 1);
            } else {
                btn.prop("disabled", true);
                clearInterval(action);
            }
        } else {

            if (input.attr('min') == undefined || parseInt(input.val()) > parseInt(input.attr('min'))) {
                input.val(parseInt(input.val()) - 1);
            } else {
                btn.prop("disabled", true);
                clearInterval(action);
            }
        }
    });

};
    