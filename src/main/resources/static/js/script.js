
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

});
