<!DOCTYPE html>
<html>
<head>
<title>SimplePoll</title>
</head>
<body>

<% if (request.getAttribute("errors") != null) { %>
		<div id="errors"><ul>
		<% if (request.getAttribute("question_error") != null) { %>
			<li>The question cannot be empty</li>
		<% } %>
		</ul></div>		
<% } %>
	
	<form name="poll" action="" method="POST">
		
		<label for="question">Question: </label>
		<input type="text" name="question"></input>
		
		<label for="option1">1. </label>
		<input type="text" name="option1"></input>
		
		<label for="option2">2. </label>
		<input type="text" name="option2"></input>
		
		<label for="option3">3. </label>
		<input type="text" name="option3"></input>

		<label for="option4">4. </label>
		<input type="text" name="option4"></input>
		
		<input type="submit" value="Create poll"></input>
	</form>
	
</body>
</html>