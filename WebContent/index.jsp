<!DOCTYPE HTML>
<html>
<head>
	<title>Server-Sent Events Servlet example</title>
	<style>
		body {
			font-family: sans-serif;
		}
	</style>
	<script type="text/javascript" src="js/eventSource.js"></script>
</head>
<body>

	Time: <span id="foo"></span>
	
	<br><br>
	<button onclick="start()">Start</button>

	<script>
	function start() {
		var eventSource = new EventSource("HelloServlet");
		
		eventSource.addEventListener("message", function(e) {
			document.getElementById('foo').innerHTML = event.data;
		}, false);
	}
		
	</script>
</body>
</html>