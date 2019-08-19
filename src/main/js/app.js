document.addEventListener("DOMContentLoaded", function (evt) {

    console.log("działa", $);

    $('.nav').on('click', 'li', function () {
        $(this).toggle('active');
    });
});