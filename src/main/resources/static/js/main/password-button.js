// 비밀번호 표시 숨김
$passwordShowButton = $(".password-show-button");

$passwordInput = $(".input-password");
$passwordShowButton.click((e) => {
    if (!$passwordShowButton.hasClass("show")) {
        $passwordInput.attr("type", "password");
        $passwordShowButton.removeClass("show");
        $passwordShowButton.text("숨김");
    } else {
        $passwordInput.attr("type", "text");
        $passwordShowButton.addClass("show");
        $passwordShowButton.text("표시");
    }
});