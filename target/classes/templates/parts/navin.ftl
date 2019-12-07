<#macro navin>
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
                <li class="nav-item">
                    <a class="nav-link" href="/datedev">Date</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-2" method="post" action="/createDevice" enctype="multipart/form-data">
                <input class="form-control mr-sm-2 col-md-3" type="text" placeholder="serial" aria-label="serial" name="serial">

                    <select class="form-control mr-sm-2 col-md-3" name="model"  >
                        <#list models as m>
                            <option value="${m.id}">${m.model}</option>
                        </#list>
                    </select>

                    <select class="form-control mr-sm-2 col-md-3" name="brand"  >
                        <#list brands as b>
                            <option value="${b.id}">${b.brand}</option>
                        </#list>
                    </select>

                <select class="form-control mr-sm-2 col-md-3" name="types"  >
                    <#list types as t>
                        <option value="${t.id}">${t.type}</option>
                    </#list>
                </select>

                <button class="btn btn-outline-success my-2 my-sm-2 mr-2" type="submit">Добавить</button>
            </form>
            <form class="form-inline my-2 my-lg-2" method="post" action="/searchDevice" enctype="multipart/form-data">
                <input class="form-control mr-sm-2 col-md-4" type="text" placeholder="Search" aria-label="Search" name="searchDevice">
                <button class="btn btn-outline-success my-2 my-sm-2 mr-2" type="submit">Найти</button>
            </form>
            <form action="/logout" method="post">
                <input type="submit" class="btn btn-outline-success my-2 my-sm-2 mr-2" value="Sign Out"/>
            </form>
        </div>
        </div>
    </nav>
</#macro>