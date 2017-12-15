<html>
<head>
<link rel="stylesheet" href="/uaa/css/wro.css"/>
</head>
<body>
	<div class="container">
		<h2>Please Confirm</h2>

		<p>
			Do you authorize "${authorizationRequest.clientId}" at "${authorizationRequest.redirectUri}" to access your protected resources
			with scope ${authorizationRequest.scope?join(", ")}.
		</p>
		<form id="confirmationForm" name="confirmationForm"
			action="/uaa/oauth/authorize" method="post">
			<input name="user_oauth_approval" value="true" type="hidden" />
			<input name="scope.all" value="true" type="hidden" />
			<input type="hidden" id="csrf_token" name="${(_csrf.parameterName)!''}" value="${(_csrf.token)!''}"/>
			<button class="btn btn-primary" type="submit">授权</button>
		</form>
		<form id="denyForm" name="confirmationForm"
			action="/uaa/oauth/authorize" method="post">
			<input name="user_oauth_approval" value="false" type="hidden" />
			<input type="hidden" id="csrf_token" name="${(_csrf.parameterName)!''}" value="${(_csrf.token)!''}"/>
			<button class="btn btn-primary" type="submit">拒绝</button>
		</form>
	</div>
	<script src="/uaa/js/wro.js"	type="text/javascript"></script>
</body>
</html>