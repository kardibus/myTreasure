<#macro navus>
    <nav class="navbar navbar-expand-lg navbar-light bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="/">Device</a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/model">Model</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/brand">Brand</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/type">Type</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/users">Users</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-2" method="post" action="/createUsers" enctype="multipart/form-data">
                <input class="form-control mr-sm-2" type="text" placeholder="name" aria-label="name" name="name">
                <input class="form-control mr-sm-2" type="text" placeholder="surname" aria-label="surname" name="surname">
                <input class="form-control mr-sm-2" type="text" placeholder="patronymic" aria-label="patronymic" name="patronymic">
                <input class="form-control mr-sm-2" type="text" placeholder="numberOne" aria-label="numberOne" name="numberOne">
                <input class="form-control mr-sm-2" type="text" placeholder="numberTwo" aria-label="numberTwo" name="numberTwo">
                <input class="form-control mr-sm-2" type="text" placeholder="numberThree" aria-label="numberThree" name="numberThree">

                <select class="form-control mr-sm-2 col-md-3" name="model"  >
                    <#list devices as device>
                        <option value="${device.id}">${device.serial}</option>
                    </#list>
                </select>
                <button class="btn btn-outline-success my-2 my-sm-2 mr-2" type="submit">Добавить</button>
            </form>
            <form class="form-inline my-2 my-lg-2" method="post" action="/searchUsers" enctype="multipart/form-data">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="search">
                <button class="btn btn-outline-success my-2 my-sm-2 mr-2" type="submit">Найти</button>
            </form>
        </div>
    </nav>
</#macro>