<#import "parts/common.ftl" as c>
<#import "parts/navus.ftl" as nus>

<@c.top></@c.top>
<@nus.navus></@nus.navus>
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">№</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Имя</th>
        <th scope="col">Отчество</th>
        <th scope="col">Номер 1</th>
        <th scope="col">Номер 2</th>
        <th scope="col">Номер 3</th>
        <th scope="col">Аппарат</th>
        <th scope="col">Удалить</th>
        <th scope="col">Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <#list users as users>
        <tr>
            <th scope="row">${users.id}</th>
            <td>${users.surname}</td>
            <td>${users.name}</td>
            <td>${users.patronymic}</td>
            <td>${users.numberOne?string("#####")}</td>
            <td>${users.numberTwo?string("#####")}</td>
            <td>${users.numberThree?string("#####")}</td>
            <td>${users.device.serial}</td>
            <td><form method="post" action="/deleteUsers/${users.id}" enctype="multipart/form-data">
                    <button type="submit" class="btn btn-secondary">Удалить</button></form></td>

            <td><a class="btn btn-secondary mb-3"  data-toggle="collapse" href="#collapseExample${users.id}" role="button" aria-expanded="false" aria-controls="collapseExample${users.id}">
                    Редактировать
                </a>
                <div class="collapse" id="collapseExample${users.id}">
                    <div class="form-group mt-3">
                        <form method="post" action="/updateUsers/${users.id}" enctype="multipart/form-data">
                            <div class="form-group">
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="surname" value="${users.surname}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="name" value="${users.name}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="patronymic" value="${users.patronymic}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="numberOne" value="${users.numberOne?string("#####")}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="numberTwo" value="${users.numberTwo?string("#####")}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="numberThree" value="${users.numberThree?string("#####")}">
                                </div>

                                <div class="form-group">
                                    <select class="form-control mr-sm-4 col-md-4" name="device"  >
                                        <#list devices as device>
                                            <option value="${device.id}">${device.serial}</option>
                                        </#list>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-secondary">Сохранить</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div></td>
        </tr>
        </tr>
    </#list>
    </tbody>
</table>

</body>
</html>