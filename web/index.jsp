<%@ page import="java.sql.*" %>

<%  Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/viraj", "root", "system manager"); %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style1.css">
        <title>Web Notes</title>
    </head>

    <body>
        <div class="toggle">
            <div class="container main">
                <h2>Add Notes</h2>
                <form action="send" method="get" class="add-note">

                    <table>
                        <tr>
                            <td>Note Title</td>
                        </tr>
                        <tr>
                            <td><input type="text" name="title"
                                       class="input-type"
                                       placeholder="Enter note title"
                                       id="title" required></td>
                        </tr>
                        <tr style="height: 50px; vertical-align: bottom;">
                            <td>Note Description</td>
                        </tr>
                        <tr>
                            <td><textarea name="desc" id="desc" cols="51"
                                          rows="5"
                                          placeholder="Enter Discription of title" required></textarea>
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="Add" class="submit" id="submit">
                    <input type="button" value="Close" class="submit closeNote">
                </form>
            </div>
        </div>
        <div class="container navbar">
            <nav>
                <ul>
                    <li style="font-size: 20px;">I-notes</li>
                </ul>
            </nav>
        </div>



        <div class="search">
            <button id="addNote" class="">Add Note</button>
            <input class="find" type="text" placeholder="Search Note">

        </div>


        <div class="container result-tbl">

            <div class="center-result">
                <%
                    Statement st = conn.createStatement();
                    String query = "select * from inode order by Sr_no desc";

                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {%>
                <form action="delete" method="get">
                    <div class='card'>
                        <div class="close"> 
                            <button type="submit" class='delete_btn'>
                                <input name='id' type="hidden" value='<%=rs.getInt(1)%>'>
                                <div class="delete_div"> Delete </div> 
                            </button>
                        </div>
                        <table class='result-table'>
                            <tr>
                                <td> Title  </td>
                            </tr>
                            <tr>
                                <td>
                                    <p class="card-detail"><%=rs.getString("title")%> </p>
                                </td>
                            </tr>
                            <tr style='height: 30px; vertical-align: bottom;'>
                                <td> Description </td>
                            </tr>
                            <tr>
                                <td>
                                    <p class='card-detail'> <%=rs.getString("disc")%> </p>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>
                <%
                    }
                %>
            </div>
        </div>


        <script src="./jquery.js">
        </script>
        <script>
            $(document).ready(function () {
                $('.find').on('keyup', function () {
                    var value = $(this).val().toLowerCase();
                    $('.center-result form').filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                    });
                });

                $('#addNote').on('click', function () {
                    $('.toggle').slideDown(500);
                });
                
                $('.closeNote').on('click', function () {
                    $('.toggle').slideUp(500);
                });

            });
        </script>

    </body>
</html>