$(document).ready(function () {
    $.post("api/users/2ea43c37-8981-4136-a646-dc6d87e2c5ca/passwords", function (data) {
        console.log(data)
        $(".result").html(data.password);
    });
});