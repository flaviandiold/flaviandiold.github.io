<%@include file="header.jsp" %>

    <div class="fillform">
        <a class="homerights" href="admin_rights">Home</a>
    </div>

    <form method="post">
        <button type="submit" id="submit">Show Bookings</button>
    </form>

    <form>
        <c:if test="${PassengerName!=null}">

            <div class="scrollable">
                <table class="searchdetail" align="center">
                    <thead>
                        <tr>
                            <th>${PassengerName}</th>
                            <th>${FlightNo}</th>
                            <th>${From}</th>
                            <th>${To}</th>
                            <th>${DepartureDate}</th>
                            <th>${ArrivalDate}</th>
                            <th>${DepartureTime}</th>
                            <th>${ArrivalTime}</th>
                            <th>${Class}</th>
                            <th>${SeatNumber}</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${Booking_list}" var="list">

                            <tr>
                                <c:set var="B" value="booked" />
                                <c:if test="${list.p_status eq B}">
                                    <td>${list.p_name}</td>
                                    <td>${list.p_fno}</td>
                                    <td>${list.p_from}</td>
                                    <td>${list.p_to}</td>
                                    <td>${list.p_dedate}</td>
                                    <td>${list.p_ardate}</td>
                                    <td>${list.p_detime}</td>
                                    <td>${list.p_artime}</td>
                                    <td>${list.p_class}</td>
                                    <td>${list.p_seatno}</td>
                                </c:if>
                            <tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
    </form>
    </c:if>

    <%@include file="footer.jsp" %>