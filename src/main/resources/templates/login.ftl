<#import "parts/common.ftl" as c>
<@c.top></@c.top>
<style>
        .block-div-div
        {
                margin: 90px auto;
                width: 400px;
        }
</style>
<p>${message?ifExists}</p>
<div class="block-div-div">
<form method="post" action="/login/" enctype="multipart/form-data">
        <label for="exampleInputEmail1">Email address</label>
        <input type="text" class="form-control mr-sm-4 col-md-4" id="exampleInputEmail1" name="username">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control mr-sm-4 col-md-4" id="exampleInputPassword1" name="password">

        <button type="submit" class="btn btn-primary my-2 mr-sm-4 col-md-4">Войти</button>
</form>
        <a href="/registration">Add</a>
</div>
</body>
</html>