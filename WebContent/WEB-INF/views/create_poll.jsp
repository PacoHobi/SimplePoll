<!DOCTYPE html>
<html>
<head>
	<title>SimplePoll</title>
	<link href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700|Roboto+Slab:400,300" rel="stylesheet" type="text/css">
	<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="wrapper">

	<div id="logo">
		Simple<span class="alter">Poll</span>
	</div>

	<% if (request.getAttribute("errors") != null) { %>
		<div id="errors"><ul>
		<% if (request.getAttribute("question_error") != null) { %>
			<li>The question cannot be empty</li>
		<% } %>
		</ul></div>		
	<% } %>
	
	<form id="create_poll" name="poll" action="" method="POST">
		
		<div class="question">
			<input type="text" name="question" placeholder="Write your question here"></input>
		</div>
		
		<div class="option">
			<label for="option1">1. </label>
			<input type="text" name="option1"></input>
		</div>
		
		<div class="option">
			<label for="option2">2. </label>
			<input type="text" name="option2"></input>
		</div>
		
		<div class="option">
			<label for="option3">3. </label>
			<input type="text" name="option3"></input>
		</div>

		<div class="option">
			<label for="option4">4. </label>
			<input type="text" name="option4"></input>
		</div>
		
		<input id="create_button" type="submit" value="Create poll"></input>
		
	</form>

	<div id="footer">
		Created by <a href="http://www.pacohobi.com" target="_blank">Paco Hobi</a>
	</div>

</div>
	
</body>
</html>