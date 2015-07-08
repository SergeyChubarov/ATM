$(document).ready(function() {
    $('#pin-number-block').hide();
    $("#card-number").inputmask({ "mask": "9999-9999-9999-9999", "repeat": 1, "greedy": false });
    $("#pin-number").inputmask({ "mask": "9", "repeat": 4, "greedy": false });

    addHandlers();
});

var addHandlers = function () {

    // number buttons
    $('.number-btn').on('click', function (event) {
        var isCardNumberBlockVisible = $('#card-number-block').is(':visible'),
            $chosenInput = isCardNumberBlockVisible? $('#card-number'): $('#pin-number'),
            currentNumber = $chosenInput.val(),
            chosenNumber = event.currentTarget.textContent;

        $chosenInput.val(currentNumber + chosenNumber);
    });

    // clear button
    $('.clear').on('click', function () {
        clearInputs();
    });

    // submit card button
    $('.submit-card').on('click', function () {
        checkCardStatus();
    });

};

var clearInputs = function () {
    $('#card-number').val("");
    $('#pin-number').val("");
};

var checkCardStatus = function () {
    var cardNumberValue = $('#card-number').val(),
        cardNumber = cardNumberValue.replace(/([-_])/g, '');

    // show error message if card number invalid
    if (cardNumber.length < 16) {
        showAlert("Invalid card number.");
        return false;
    }

    $.ajax({
        type: "get",
        url: "/card/" + 2 + "/isBlocked",
        success: function (isBlocked) {
            if (isBlocked) {
                showAlert("Card with number " + cardNumber + " is blocked.");
            } else {
                $('#card-number-block').hide();
                $('#pin-number-block').show();
            }
        },
        error: function () {
            showAlert("Internal server error. Please contact administrator.");
        }
    });
};

var showAlert = function (message) {
    $('#alert-container').html($("#alert-template").html());
    $('#message').text(message);
};




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



//$('.clear').click(function() {
//    $.blockUI({ css: {
//        border: 'none',
//        padding: '15px',
//        backgroundColor: '#000',
//        '-webkit-border-radius': '10px',
//        opacity: .5,
//        color: '#fff'
//    } });
//
//    setTimeout($.unblockUI, 2000);
//});