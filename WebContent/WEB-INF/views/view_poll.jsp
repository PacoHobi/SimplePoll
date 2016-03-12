<%@ page import="java.util.List, java.util.ArrayList, com.simplepoll.models.Poll, com.simplepoll.models.PollOption" %>

<%

Poll poll = (Poll) request.getAttribute("poll");

%>

<!DOCTYPE html>
<html>
<head>
<title>SimplePoll</title>
</head>
<body>

	<h2><%= poll.getQuestion() %></h2>
	
	<form action="" method="POST">
	
		<%
			for (PollOption option : poll.getOptions()) {
		%>
			<input type="radio" name="option_id" value="<%= option.getId() %>">
			<%= option.getText() %>
			<br>
	
		<%
			}
		%>
		
		<input type="hidden" name="poll_id" value="<%= poll.getId() %>">
		<input type="submit" value="Vote">
		
	</form>
		
</body>
</html>