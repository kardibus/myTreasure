<#import "parts/common.ftl" as c>
<@c.top></@c.top>
<style>
    .block-div-div
    {
        margin: 90px auto;
        width: 400px;
    }
</style>

<div class="block-div-div">
       <p>${message}</p>
    <form method="post" action="/registration" enctype="multipart/form-data">
        <label for="exampleInputEmail1">Email address</label>
        <input type="text" class="form-control mr-sm-4 col-md-4" id="exampleInputEmail1" name="username">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control mr-sm-4 col-md-4" id="exampleInputPassword1" name="password">
        <button type="submit" class="btn btn-primary my-2 mr-sm-4 col-md-4">Добавить</button>
    </form>
</div>
</body>
</html>