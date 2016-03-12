<%@ page import="java.util.List, java.util.ArrayList, com.simplepoll.models.Poll, com.simplepoll.models.PollOption" %>

<%

Poll poll = (Poll) request.getAttribute("poll");

%>

<!DOCTYPE html>
<html>
<head>
	<title>SimplePoll</title>
	<link href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700|Roboto+Slab:400,300" rel="stylesheet" type="text/css">
	<link href="../css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	
<div id="wrapper">

	<div id="logo">
		Simple<span class="alter">Poll</span>
	</div>

	<div id="question"><%= poll.getQuestion() %></div>

	<form id="view_poll" action="" method="POST">

		<%
			for (int i = 0; i < poll.getOptions().size(); i++) {
				PollOption option = poll.getOptions().get(i);
		%>

			<div class="option">
				<input type="radio" name="option_id" value="<%= option.getId() %>" id="r<%= i %>">
				<label for="r<%= i %>"><%= option.getText() %></label>
			</div>
	
		<%
			}
		%>

		<input type="hidden" name="poll_id" value="<%= poll.getId() %>">
		<input type="submit" value="Vote">
		
	</form>
	
	<div id="footer">
		Created by <a href="http://www.pacohobi.com" target="_blank">Paco Hobi</a>
	</div>

</div>
		
</body>
</html>