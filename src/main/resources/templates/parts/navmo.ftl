<#macro navmo>
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
            </ul>
            <form class="form-inline my-2 my-lg-2" method="post" action="/createModel" enctype="multipart/form-data">
                <input class="form-control mr-sm-2" type="text" placeholder="model" aria-label="model" name="model">
                <button class="btn btn-outline-success my-2 my-sm-2 mr-2" type="submit">Добавить</button>
            </form>
            <form class="form-inline my-2 my-lg-2" method="post" action="/searchModel" enctype="multipart/form-data">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="searchModel">
                <button class="btn btn-outline-success my-2 my-sm-2 mr-2" type="submit">Найти</button>
            </form>
        </div>
    </nav>
</#macro>