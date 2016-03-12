<%@ page import="java.util.List, java.util.ArrayList, com.simplepoll.models.Poll, com.simplepoll.models.PollOption" %>

<%

Poll poll = (Poll) request.getAttribute("poll");

long totalVotes = 0;

for (PollOption opt : poll.getOptions()) {
	totalVotes += opt.getVotes();
}

totalVotes = totalVotes == 0 ? 1 : totalVotes;

%>

<!DOCTYPE html>
<html>
<head>
	<title>SimplePoll</title>
	<link href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700|Roboto+Slab:400,300,100" rel="stylesheet" type="text/css">
	<link href="../css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	
<div id="wrapper">

	<div id="logo">
		Simple<span class="alter">Poll</span>
	</div>

	<div id="question"><%= poll.getQuestion() %></div>

	<div id="poll_results">
	
		<%
			for (PollOption option : poll.getOptions()) {
				int percentage = (int) (100 * option.getVotes() / totalVotes);
		%>
			<div class="option">
				<span class="text"><%= option.getText() %></span>
				<span class="progressbar">
					<span style="width: <%= percentage %>%"></span>
				</span>
				<span class="numbers"><%= option.getVotes() %> votes (<%= percentage %>%)</span>
			</div>
		<%
			}
		%>
		
	</div>

	<div id="footer">
		Created by <a href="http://www.pacohobi.com" target="_blank">Paco Hobi</a>
	</div>

</div>
		
</body>
</html>