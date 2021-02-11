
$(document).ready(function(){

    // Modal

    $('[data-modal=add]').on('click', function() {
        $('.overlay, #add').fadeIn('slow');
    });
    $('[data-modal=booksadd]').on('click', function() {
        $('.overlay, #booksadd').fadeIn('slow');
    });
    $('[data-modal=readersadd]').on('click', function() {
        $('.overlay, #readersadd').fadeIn('slow');
    });
    $('[data-modal=search]').on('click', function() {
        $('.overlay, #search').fadeIn('slow');
    });
    $('.modal__close').on('click', function(){
       $('.overlay, #add, #booksadd, #readersadd, #search').fadeOut('slow');
    });
    $('.modal__button').on('click', function(){
        $('.overlay, #add, #booksadd, #readersadd, #search').fadeOut('slow');
     });
    $('[data-modal=readers]').on('click', function() {
        $('#readers').fadeIn('1');
        $('#books, #user').fadeOut('1');
    });
    $('[data-modal=books]').on('click', function() {
        $('#books').fadeIn('1');
        $('#readers, #user').fadeOut('1');
    });
    $('[data-modal=user]').on('click', function() {
        $('#user').fadeIn('1');
        $('#readers, #books').fadeOut('1');
    });


});
