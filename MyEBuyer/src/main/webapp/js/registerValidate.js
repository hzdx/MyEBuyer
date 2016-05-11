var isNameOk = false;
var isSubmit = false;
function hyz(){
    var img = document.getElementById("imgVerifyCode");
    img.src="/verifycode?a="+ new Date().getTime();
}

function validatePsw(){
    var psw = $('#psw').val();
    return /^[=/@!#~%&,?;':"<>\|\[\]\{\}\\\(\)\w\s\$\^\-\*\.\+]{6,16}$/.test(psw);
}

function validatePsw2(){
    return $('#psw').val() === $('#psw2').val();
}
function validatePhone(){
    return /^1[358][0-9]{9}$/.test($('#phone').val());
}
function validateVcode(){
    return $.trim($('#vcode').val()) !== '';
}
function submitRegisterInfo(){
    if(isNameOk && validatePsw() && validatePsw2() && validatePhone() ){
        if(!isSubmit) {
            isSubmit = true;

            $.ajax({
                cache: true,
                url: '/user/register.json',
                type: 'post',
                data: $('#userRegisterForm').serialize(),
                success: function (data) {
                    if (data.status === 'ok') {
                        location.href = "regsuccess.html";
                    } else {
                        isSubmit = false;
                        alert(data.message);
                    }
                },
                error: function (request) {
                    alert("Connection error");
                    isSubmit = false;
                }
            });
        }
    }else alert('表单参数不合法，请修改后再提交！');
}
$(function () {
    $("#nameText").blur(function () {
        var username = $(this).val();
        if($.trim(username) !== '') {
            $.get("/user/checkName.json", {'name': username}, function (data) {
                if (data === false) {
                    $("#checkName").html("<font color='green'>此用户名可以使用<font>");
                    isNameOk = true;
                }
                else{
                    isNameOk = false;
                    $("#checkName").html("<font color='red'>此用户名已经存在<font>");
                }
            });
        }else isNameOk = false;
    });

    $("#psw").blur(function () {
        if(!validatePsw()) $('#checkPsw').html("<font color='red'>密码必须是6~16位字符<font>");
        else {
            //$('#md5psw').val($.md5($(this).val()));
            //todo 密码发送到服务端使用md5加密
            $('#checkPsw').html("<font color='green'>密码可以使用<font>");
        }
    });

    $("#psw2").blur(function () {
        if(!validatePsw2()) $('#checkPsw2').html("<font color='red'>两次密码必须一样<font>");
        else $('#checkPsw2').html("<font color='green'>两次密码一样<font>");
    });

    $("#phone").blur(function () {
        if(!validatePhone()) $('#checkPhone').html("<font color='red'>手机号不正确<font>");
        else $('#checkPhone').html("<font color='green'>手机号可以使用<font>");
    });

    $("#vcode").blur(function () {
        if(!validateVcode()) $('#checkVcode').html("<font color='red'>验证码不能为空<font>");
        else $('#checkVcode').html("<font color='green'>验证码可行<font>");
    });
});