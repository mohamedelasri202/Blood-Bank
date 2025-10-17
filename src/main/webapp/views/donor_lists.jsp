<%@ page import="com.bloodbank.model.BloodType" %>
<%@ page import="com.bloodbank.model.AvailabilityStatusRecipient" %>
<%@ page import="com.bloodbank.model.AvailabilityStatus" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Recipients - LifeStream Blood Bank</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@300;400;500;600;700&family=Inter:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        .font-serif { font-family: 'Cormorant Garamond', serif; }
        .font-sans { font-family: 'Inter', sans-serif; }
    </style>
</head>
<body class="font-sans bg-gradient-to-br from-slate-50 to-stone-100 min-h-screen">

<%-- Get donor info from session --%>
<%
    BloodType bloodtype = (BloodType) session.getAttribute("donorBloodtype");
    com.bloodbank.model.AvailabilityStatus donorStatus =
            (com.bloodbank.model.AvailabilityStatus) session.getAttribute("donorStatus");
%>



<nav class="fixed w-full z-50 bg-white/80 backdrop-blur-md border-b border-stone-200">
    <div class="max-w-7xl mx-auto px-6 lg:px-8">
        <div class="flex justify-between items-center h-20">
            <div class="flex items-center gap-3">
                <img src="${pageContext.request.contextPath}/images/logo.webp" alt="LifeStream Logo" class="h-12 w-12 rounded-full object-cover border-2 border-rose-200">
            </div>
            <div class="hidden md:flex items-center gap-8">
                <a href="${pageContext.request.contextPath}/" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">Home</a>
                <a href="${pageContext.request.contextPath}/list?view=donors" class="text-neutral-900 font-semibold text-sm">Donors</a>
                <a href="${pageContext.request.contextPath}/list?view=receivers" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">Recipients</a>
                <a href="${pageContext.request.contextPath}/views/donorForm.jsp" class="px-6 py-2.5 bg-neutral-900 text-white text-sm font-medium hover:bg-neutral-800 transition-all">Donate Now</a>
                <a href="${pageContext.request.contextPath}/views/receiverForm.jsp" class="px-6 py-2.5 border-2 border-neutral-900 text-neutral-900 text-sm font-medium hover:bg-neutral-900 hover:text-white transition-all">Request Blood</a>
            </div>
        </div>
    </div>
</nav>

<main class="pt-32 pb-20 px-6">
    <div class="max-w-7xl mx-auto">
        <div class="text-center mb-16">
            <h1 class="font-serif text-5xl md:text-6xl font-bold text-stone-800 mb-6">
                Available Recipients
            </h1>
            <p class="text-stone-600 text-lg md:text-xl max-w-2xl mx-auto leading-relaxed">
                These recipients have compatible blood types and are waiting for your generous donation
            </p>
            <div class="mt-8 inline-flex items-center gap-3 px-6 py-3 bg-rose-50 rounded-full border border-rose-200">
                <span class="text-sm font-medium text-stone-700">Your Blood Type:</span>
                <span class="px-4 py-1 bg-rose-600 text-white rounded-full text-sm font-semibold"><%= bloodtype %></span>
            </div>
        </div>

        <!-- No recipients available -->
        <c:if test="${empty receivers}">
            <div class="text-center py-20">
                <div class="max-w-md mx-auto">
                    <div class="w-24 h-24 bg-stone-100 rounded-full flex items-center justify-center mx-auto mb-6">
                        <svg class="w-12 h-12 text-stone-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M9 12h6m-6 4h6m2 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"></path>
                        </svg>
                    </div>
                    <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-3">No Recipients Available</h3>
                    <p class="text-stone-600 leading-relaxed">There are currently no recipients with compatible blood types waiting for donations.</p>
                </div>
            </div>
        </c:if>

        <!-- Recipients grid -->
        <c:if test="${not empty receivers}">
            <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                <c:forEach var="r" items="${receivers}">

                    <!-- Urgency color -->
                    <c:choose>
                        <c:when test="${r.urgency.name() == 'CRITICAL'}">
                            <c:set var="urgencyClass" value="bg-red-100 text-red-700" />
                        </c:when>
                        <c:when test="${r.urgency.name() == 'URGENT'}">
                            <c:set var="urgencyClass" value="bg-orange-100 text-orange-700" />
                        </c:when>
                        <c:otherwise>
                            <c:set var="urgencyClass" value="bg-emerald-100 text-emerald-700" />
                        </c:otherwise>
                    </c:choose>

                    <!-- Availability color -->
                    <c:choose>
                        <c:when test="${r.availability.name() == 'SATISFIED'}">
                            <c:set var="availabilityClass" value="bg-emerald-100 text-emerald-700" />
                        </c:when>
                        <c:otherwise>
                            <c:set var="availabilityClass" value="bg-amber-100 text-amber-700" />
                        </c:otherwise>
                    </c:choose>

                    <div class="bg-white rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 overflow-hidden border border-stone-200">
                        <div class="p-8">
                            <div class="flex items-center justify-between mb-6">
                                <span class="px-4 py-1.5 ${urgencyClass} rounded-full text-xs font-semibold uppercase tracking-wide">
                                        ${r.urgency}
                                </span>
                                <span class="px-3 py-1 ${availabilityClass} rounded-full text-xs font-semibold">
                                        ${r.availability}
                                </span>
                                <span class="px-4 py-1.5 bg-rose-600 text-white rounded-full text-sm font-semibold">
                                        ${r.bloodType}
                                </span>
                            </div>

                            <div class="mb-6">
                                <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-2">
                                        ${r.name} ${r.lastname}
                                </h3>
                                <div class="space-y-2 text-sm text-stone-600">
                                    <div class="flex items-center justify-between">
                                        <span class="font-medium">Blood Type:</span>
                                        <span class="font-semibold text-stone-800">${r.bloodType}</span>
                                    </div>
                                </div>
                            </div>

                            <c:choose>
                                <c:when test="${r.availability.name() == 'SATISFIED'}">
                                    <button class="w-full py-3 bg-stone-300 text-stone-500 rounded-full cursor-not-allowed font-medium tracking-wide" disabled>
                                        Already Satisfied
                                    </button>
                                </c:when>

                                <c:otherwise>
                                    <c:set var="donorStatus" value="${sessionScope.donorStatus}" />
                                    <form action="${pageContext.request.contextPath}/donate" method="post">
                                        <input type="hidden" name="donor_id" value="${donorId}">
                                        <input type="hidden" name="receiver_id" value="${r.id}">

                                        <c:choose>
                                            <c:when test="${donorStatus == 'AVAILABLE'}">
                                                <button
                                                        type="submit"
                                                        class="w-full py-3 bg-rose-600 text-white rounded-full hover:bg-rose-700 transition-all font-medium tracking-wide shadow-md hover:shadow-lg">
                                                    Donate Now
                                                </button>
                                            </c:when>

                                            <c:otherwise>
                                                <button
                                                        type="button"
                                                        disabled
                                                        class="w-full py-3 bg-stone-300 text-stone-500 rounded-full cursor-not-allowed font-medium tracking-wide opacity-70">
                                                    Donate Now
                                                </button>
                                                <p class="text-red-600 mt-2 font-medium">
                                                    You cannot donate again. You have already donated.
                                                </p>
                                            </c:otherwise>
                                        </c:choose>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</main>

</body>
</html>
