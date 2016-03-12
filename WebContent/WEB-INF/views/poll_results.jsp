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
</head>
<body>

	<h2><%= poll.getQuestion() %></h2>
	
	<table>
		<tr>
			<th>Option</th>
			<th>Votes</th>
			<th>Percentage</th>
		</tr>
		
		<%
			for (PollOption option : poll.getOptions()) {
		%>
		
			<tr>
				<td><%= option.getText() %></td>
				<td><%= option.getVotes() %></td>
				<td><%= 100 * option.getVotes() / totalVotes %>%</td>
			</tr>
			
		<%
			}
		%>
	
	</table>
</body>
</html>