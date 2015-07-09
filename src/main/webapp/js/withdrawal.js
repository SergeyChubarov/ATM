$(document).ready(function() {
    $("#withdrawal-amount").inputmask({ "mask": "9", "repeat": 5, "greedy": false });
    $("#card-number-holder").inputmask({ "mask": "9999-9999-9999-9999", "repeat": 1, "greedy": false });
    addHandlers();
});

var addHandlers = function () {
    // number buttons
    $('.number-btn').on('click', function (event) {
        var $withdrawalAmount = $("#withdrawal-amount"),
            currentNumber = $withdrawalAmount.val(),
            chosenNumber = event.currentTarget.textContent;

        if (!(chosenNumber === "0" && currentNumber === "")) {
            $withdrawalAmount.val(currentNumber + chosenNumber);
        }
    });

    // clear button
    $('.clear-withdrawal-amount').on('click', function () {
        $('#withdrawal-amount').val("");
    });

    // OK button
    $('.submit-withdraw').on('click', function () {
        withdrawalOperation();
    });
};

var withdrawalOperation = function () {
    var withdrawalAmount = $('#withdrawal-amount').val();

    if (withdrawalAmount === "" || withdrawalAmount === "0") {
        $('#alert-container').html($("#alert-template").html());
        $('#message').text("Invalid withdrawal amount.");
    }

    $.ajax({
        type: "post",
        url: "/withdraw",
        data: {
            cardNumber: $('#card-number-holder').val().replace(/([-_])/g, ''),
            operationCode: "Withdraw",
            withdrawalAmount: withdrawalAmount
        },
        success: function (response) {
            if (response.withdrawalAmount === 0) {
                $('#alert-container').html($("#alert-template").html());
                $('#message').text("Not enough money for withdrawals.");
                return false;
            }
            window.location.href = 'report?cardNumber=' + response.number + "&balance=" + response.balance + "&withdrawalAmount=" + response.withdrawalAmount;
        }
    });

};