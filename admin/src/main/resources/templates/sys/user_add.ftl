<form class="form-horizontal" role="form" id="adduser" enctype="multipart/form-data" method="post">
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="loginName">登录名</label>

        <div class="col-sm-9">
            <input type="text" id="loginName" name="loginName" placeholder="登录名" class="col-xs-10 col-sm-5" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="userName">用户名</label>

        <div class="col-sm-9">
            <input type="text" id="userName" placeholder="用户名" class="col-xs-10 col-sm-5" />
        </div>
    </div>

    <div class="space-4"></div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 密码 </label>

        <div class="col-sm-9">
            <input type="password" id="password" placeholder="密码" class="col-xs-10 col-sm-5" />
            <span class="help-inline col-xs-12 col-sm-7">
				<span class="middle">最少6位</span>
			</span>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="userName">身份证</label>

        <div class="col-sm-9">
            <input type="file" id="file" name="file" class="col-xs-10 col-sm-5" />
        </div>
    </div>

</form>