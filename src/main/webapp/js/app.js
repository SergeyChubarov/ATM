$(document).ready(function() {
    $('#pin-number-block').hide();


    $('.clear').click(function() {
        $.blockUI({ css: {
            border: 'none',
            padding: '15px',
            backgroundColor: '#000',
            '-webkit-border-radius': '10px',
            opacity: .5,
            color: '#fff'
        } });

        setTimeout($.unblockUI, 2000);
    });
});

$(document).on('click', '.number-btn', function (event) {
    var $cardNumber = $('#card-number'),
        currentNumber = $cardNumber.val(),
        chosenNumber = event.currentTarget.textContent;
    console.log(event.currentTarget.textContent);
    $cardNumber.val(currentNumber + chosenNumber);
});

//$(document).on('click', '.clear', function (event) {
//    $('#card-number').val("");
//});

$(document).on('click', '.submit-card', function (event) {
    var cardNumber = $('#card-number').val();
    $.ajax({
        type: "get",
        url: "/card/" + cardNumber + "/isBlocked",
        success: function (response) {
            console.log("asdasd " + response);
            $('#card-number-block').hide();
            $('#pin-number-block').show();
        }
    });
});

$(document).on('click', '.submit-pin', function (event) {
    var cardNumber = $('#card-number').val();
    var pinNumber = $('#pin-number').val();
    $.ajax({
        type: "get",
        url: "/card/" + cardNumber + "/pin/" + pinNumber + "/checkPinNumber",
        success: function (response) {

            console.log("asdasd " + response);
//            $('#card-number-block').hide();
//            $('#pin-number-block').show();
        }
    });
});