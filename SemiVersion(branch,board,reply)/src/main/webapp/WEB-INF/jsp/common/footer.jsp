<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class='footer'>
	<footer id="footer">
		<div class="copyright">
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook" id="loginBtn"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
			</ul>
			<p>
				&copy; Untitled. All rights reserved. Design: <a
					href="https://templated.co">TEMPLATED</a>. Images: <a
					href="https://unsplash.com">Unsplash</a>.
			</p>

		</div>
	</footer>

	<script>
		function getUserData() {
			/* FB.api('/me', function(response) {
			    document.getElementById('response').innerHTML = 'Hello ' + response.name;
			    console.log(response);
			}); */
			FB.api('/me', {
				fields : 'name,email,gender'
			}, function(response) {
				console.log(JSON.stringify(response));
				$("#name").text("이름 : " + response.name);
				$("#email").text("이메일 : " + response.email);
				$("#gender").text("성별 : " + response.gender);
				console.log('aaa');
			});
			console.log('bbb');
		}

		window.fbAsyncInit = function() {
			//SDK loaded, initialize it
			FB.init({
				appId : '1642835115777308',
				cookie : true, // enable cookies to allow the server to access
				// the session
				xfbml : true, // parse social plugins on this page
				version : 'v2.8' // use graph api version 2.8
			});

			//check user session and refresh it
			FB.getLoginStatus(function(response) {
				if (response.status === 'connected') {
					//user is authorized
					//document.getElementById('loginBtn').style.display = 'none';
					getUserData();
				} else {
					//user is not authorized
				}
			});
		};

		//load the JavaScript SDK
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.com/ko_KR/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		//add event listener to login button
		document.getElementById('loginBtn').addEventListener('click',
				function() {
					//do the login
					FB.login(function(response) {
						if (response.authResponse) {
							access_token = response.authResponse.accessToken; //get access token
							user_id = response.authResponse.userID; //get FB UID
							console.log('access_token = ' + access_token);
							console.log('user_id = ' + user_id);
							$("#access_token").text("접근 토큰 : " + access_token);
							$("#user_id").text("FB UID : " + user_id);
							//user just authorized your app
							//document.getElementById('loginBtn').style.display = 'none';
							getUserData();
						}
					}, {
						scope : 'email,public_profile',
						return_scopes : true
					});
				}, false);
	</script>
</div>