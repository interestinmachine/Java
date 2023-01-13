function checkLogin() {
    $.ajax({
        type: 'get',
        url: 'login',
        success: function() {
            // 登录成功，不必做任何处理
        },
        error: function() {
            // 403 会触发error
            // 强行跳转到登录页面
            location.assign('blog_login.html');
        }
    });
}



