<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Urban by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>Bigdata-IoT ver.3</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/assets/css/main.css" />

<!-- Favicon and touch icons -->
<link rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/ico/home_iot.png">
</head>

<body>

	<!-- Header -->
	<jsp:include page="../common/headeralt.jsp"></jsp:include>

	<!-- Nav -->
	<jsp:include page="../common/navi.jsp"></jsp:include>

	<!-- Banner -->
	<section id="banner">
		<div class="inner">
			<header>
				<h1>For Next Step</h1>
				<p>Home IoT system utilizing Bigdata...</p>
			</header>
			<a href="#main" class="button big scrolly">More Info</a>
		</div>
	</section>

	<!-- Main -->
	<div id="main">

		<!-- Section -->
		<section class="wrapper style1">
			<div class="inner">
				<!-- 2 Columns -->
				<div class="flex flex-2">
					<div class="col col1">
						<div class="image round fit">
							<a href="generic.html" class="link"><img
								src="${pageContext.servletContext.contextPath}/resources/images/bigdata01.jpg"
								alt="" /></a>
						</div>
					</div>
					<div class="col col2">
						<h3>제발 한달안에 끝나게 해주세요...</h3>
						<p>Etiam posuere hendrerit arcu, ac blandit nulla. Sed congue
							malesuada nibh, a varius odio vehicula aliquet. Aliquam
							consequat, nunc quis sollicitudin aliquet, enim magna cursus
							auctor lacinia nunc ex blandit augue. Ut vitae neque fermentum,
							luctus elit fermentum, porta augue. Nullam ultricies, turpis at
							fermentum iaculis, nunc justo dictum dui, non aliquet erat nibh
							non ex.</p>
						<p>Sed congue malesuada nibh, a varius odio vehicula aliquet.
							Aliquam consequat, nunc quis sollicitudin aliquet, enim magna
							cursus auctor lacinia nunc ex blandit augue. Ut vitae neque
							fermentum, luctus elit fermentum, porta augue. Nullam ultricies,
							turpis at fermentum iaculis, nunc justo dictum dui, non aliquet
							erat nibh non ex.</p>
						<a href="#" class="button">Learn More</a>
					</div>
				</div>
			</div>
		</section>

		<!-- Section -->
		<section class="wrapper style2">
			<div class="inner">
				<div class="flex flex-2">
					<div class="col col2">
						<h3>UI 구성 귀찮아 죽겠어요...</h3>
						<p>Etiam posuere hendrerit arcu, ac blandit nulla. Sed congue
							malesuada nibh, a varius odio vehicula aliquet. Aliquam
							consequat, nunc quis sollicitudin aliquet, enim magna cursus
							auctor lacinia nunc ex blandit augue. Ut vitae neque fermentum,
							luctus elit fermentum, porta augue. Nullam ultricies, turpis at
							fermentum iaculis, nunc justo dictum dui, non aliquet erat nibh
							non ex.</p>
						<p>Sed congue malesuada nibh, a varius odio vehicula aliquet.
							Aliquam consequat, nunc quis sollicitudin aliquet, enim magna
							cursus auctor lacinia nunc ex blandit augue. Ut vitae neque
							fermentum, luctus elit fermentum, porta augue. Nullam ultricies,
							turpis at fermentum iaculis, nunc justo dictum dui, non aliquet
							erat nibh non ex.</p>
						<a href="#" class="button">Learn More</a>
					</div>
					<div class="col col1 first">
						<div class="image round fit">
							<a href="generic.html" class="link"><img
								src="${pageContext.servletContext.contextPath}/resources/images/bigdata03.jpg"
								alt="" /></a>
						</div>
					</div>
				</div>
			</div>
		</section>

		<!-- Section -->
		<section class="wrapper style1">
			<div class="inner">
				<header class="align-center">
					<h2>Aliquam ipsum purus dolor</h2>
					<p>Cras sagittis turpis sit amet est tempus, sit amet
						consectetur purus tincidunt.</p>
				</header>
				<div class="flex flex-3">
					<div class="col align-center">
						<div class="image round fit">
							<img
								src="${pageContext.servletContext.contextPath}/resources/images/restaurants.jpg"
								alt="" />
						</div>
						<p>Sed congue elit malesuada nibh, a varius odio vehicula
							aliquet. Aliquam consequat, nunc quis sollicitudin aliquet.</p>
						<a href="#" class="button">Learn More</a>
					</div>
					<div class="col align-center">
						<div class="image round fit">
							<img
								src="${pageContext.servletContext.contextPath}/resources/images/restaurant01.jpg"
								alt="" />
						</div>
						<p>Sed congue elit malesuada nibh, a varius odio vehicula
							aliquet. Aliquam consequat, nunc quis sollicitudin aliquet.</p>
						<a href="#" class="button">Learn More</a>
					</div>
					<div class="col align-center">
						<div class="image round fit">
							<img
								src="${pageContext.servletContext.contextPath}/resources/images/restaurants_chicago.jpg"
								alt="" />
						</div>
						<p>Sed congue elit malesuada nibh, a varius odio vehicula
							aliquet. Aliquam consequat, nunc quis sollicitudin aliquet.</p>
						<a href="#" class="button">Learn More</a>
					</div>
				</div>
			</div>
		</section>

	</div>

	<!-- Footer -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

	<!-- Scripts -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/assets/js/jquery.scrollex.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/assets/js/skel.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/assets/js/util.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/assets/js/main.js"></script>

</body>
</html>