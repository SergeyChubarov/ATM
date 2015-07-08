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

    // clear buttons
    $('.clear-card-number').on('click', function () {
        $('#card-number').val("");
    });
    $('.clear-pin-number').on('click', function () {
        $('#pin-number').val("");
    });

    // submit card button
    $('.submit-card').on('click', function () {
        checkCardStatus();
    });

    // submit pin button
    $('.submit-pin').on('click', function () {
        checkPinNumber();
    });
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
        url: "/card/" + cardNumber + "/isBlocked",
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

var checkPinNumber = function () {
    var cardNumberValue = $('#card-number').val(),
        cardNumber = cardNumberValue.replace(/([-_])/g, ''),
        pinNumber = $('#pin-number').val(),
        maxInvalidAttempts = 4;

    // show error message if pin number invalid
    if (pinNumber.length < 4) {
        showAlert("Invalid pin number.");
        return false;
    }

    $.ajax({
        type: "get",
        url: "/card/" + cardNumber + "/pin/" + pinNumber + "/checkPinNumber",
        success: function (response) {
            $('#pin-number').val("");
            if (response.isValidPinNumber) {
                window.location.href = 'operations';
            } else if (response.isBlockedCard) {
                showAlert("Card is blocked.");
            } else {
                showAlert("Wrong pin number. You have " + (maxInvalidAttempts - response.invalidAttemptsCount) + " attempts. After that your card will be blocked.");
            }

        },
        error: function () {
            errorRequestHandler();
        }
    });

};

var showAlert = function (message) {
    $('#alert-container').html($("#alert-template").html());
    $('#message').text(message);
};

var errorRequestHandler = function () {
    showAlert("Internal server error. Please contact administrator.");
};
