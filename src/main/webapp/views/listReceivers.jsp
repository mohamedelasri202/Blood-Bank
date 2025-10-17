<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ycode
  Date: 09/10/2025
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipients List - LifeStream</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@300;400;500;600;700&family=Inter:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        .font-serif { font-family: 'Cormorant Garamond', serif; }
        .font-sans { font-family: 'Inter', sans-serif; }
    </style>
</head>
<body class="font-sans bg-neutral-50 min-h-screen">

<nav class="fixed w-full z-50 bg-white/80 backdrop-blur-md border-b border-neutral-200">
    <div class="max-w-7xl mx-auto px-6 lg:px-8">
        <div class="flex justify-between items-center h-20">
            <div class="flex items-center gap-3">
                <img src="${pageContext.request.contextPath}/images/logo.webp?height=50&width=50" alt="LifeStream Logo" class="h-12 w-12 rounded-full object-cover border-2 border-neutral-300">
                <span class="text-2xl font-serif font-semibold text-neutral-900">LifeStream</span>
            </div>
            <div class="hidden md:flex items-center gap-8">
                <a href="${pageContext.request.contextPath}/" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">Home</a>
                <a href="${pageContext.request.contextPath}/list?view=donors" class="text-neutral-900 font-semibold text-sm">Donors</a>
                <a href="${pageContext.request.contextPath}/views/listReceivers.jsp" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">Recipients</a>
                <a href="${pageContext.request.contextPath}/views/donorForm.jsp" class="px-6 py-2.5 bg-neutral-900 text-white text-sm font-medium hover:bg-neutral-800 transition-all">Donate Now</a>
                <a href="${pageContext.request.contextPath}/views/receiverForm.jsp" class="px-6 py-2.5 border-2 border-neutral-900 text-neutral-900 text-sm font-medium hover:bg-neutral-900 hover:text-white transition-all">Request Blood</a>
            </div>
        </div>
    </div>
</nav>


<main class="pt-32 pb-20 px-6 lg:px-8">
    <div class="max-w-7xl mx-auto">
        Header
        <div class="mb-12">
            <h1 class="text-5xl md:text-6xl font-serif font-light text-neutral-900 mb-4">Recipients Registry</h1>
            <p class="text-lg text-neutral-600 font-light max-w-2xl">Manage and view all blood recipients and their requests</p>
        </div>

        <div class="bg-white rounded-lg shadow-sm border border-neutral-200 overflow-hidden">
            <div class="overflow-x-auto">
                <table class="w-full">
                    <thead class="bg-neutral-900 text-white">
                    <tr>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Name</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Last Name</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Gender</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Blood Type</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Urgency</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Status</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Donor associated</th>
                        <th class="px-6 py-4 text-center text-sm font-semibold">BloodType</th>
                        <th class="px-6 py-4 text-center text-sm font-semibold">Actions</th>
                    </tr>
                    </thead>
                    <tbody class="divide-y divide-neutral-200">
                   <c:forEach var="row" items="${donations}">
                    <tr class="hover:bg-neutral-50 transition-colors">
                        <td class="px-6 py-4 text-sm text-neutral-900"><c:out value="${row[1].name}"/></td>
                        <td class="px-6 py-4 text-sm text-neutral-900"><c:out value="${row[1].lastname}"/></td>
                        <td class="px-6 py-4 text-sm text-neutral-600"><c:out value="${row[1].gender}"/></td>
                        <td class="px-6 py-4">
                            <span class="inline-flex items-center px-3 py-1 rounded-full text-xs font-medium bg-red-100 text-red-800"><c:out value="${row[1].bloodType}"/></span>
                        </td>
                        <td class="px-6 py-4">
                            <span class="inline-flex items-center px-3 py-1 rounded-full text-xs font-medium bg-red-600 text-white"><c:out value="${row[1].urgency}"/></span>
                        </td>
                        <td class="px-6 py-4">
                            <span class="inline-flex items-center px-3 py-1 rounded-full text-xs font-medium bg-yellow-100 text-yellow-800"><c:out value="${row[1].availability}"/></span>
                        </td>
                        <td><c:out value="${row[0].name} ${row[0].lastname}"/></td>
                        <td>
                          <span class="inline-flex items-center px-3 py-1 rounded-full text-xs font-medium bg-red-100 text-red-800">
                       <c:out value="${row[1].bloodType}"/>
                     </span>
                        </td>

                        <td class="px-6 py-4">
                            <div class="flex items-center justify-center gap-2">
                                <button class="px-3 py-1.5 text-xs font-medium text-neutral-700 hover:text-neutral-900 hover:bg-neutral-100 rounded transition-all">Edit</button>
                                <form action="${pageContext.request.contextPath}/donation" method="post">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="donation_id" value="${row[2].id}">
                                    <button class="px-3 py-1.5 text-xs font-medium text-red-600 hover:text-red-700 hover:bg-red-50 rounded transition-all" onclick="return confirm('Are you sure?')">Delete</button>
                                </form>

                            </div>
                        </td>
                    </tr>
                   </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
</body>
</html>
