<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Donors List - LifeStream</title>
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
                <a href="index.html" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">Home</a>
                <a href="donors-list.html" class="text-neutral-900 font-semibold text-sm">Donors</a>
                <a href="recipients-list.html" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">Recipients</a>
                <a href="donor-form.html" class="px-6 py-2.5 bg-neutral-900 text-white text-sm font-medium hover:bg-neutral-800 transition-all">Donate Now</a>
                <a href="receiver-form.html" class="px-6 py-2.5 border-2 border-neutral-900 text-neutral-900 text-sm font-medium hover:bg-neutral-900 hover:text-white transition-all">Request Blood</a>
            </div>
        </div>
    </div>
</nav>

Main Content
<main class="pt-32 pb-20 px-6 lg:px-8">
    <div class="max-w-7xl mx-auto">

        <div class="mb-12">
            <h1 class="text-5xl md:text-6xl font-serif font-light text-neutral-900 mb-4">Donors Registry</h1>
            <p class="text-lg text-neutral-600 font-light max-w-2xl">Manage and view all registered blood donors</p>
        </div>

        <div class="bg-white rounded-lg shadow-sm border border-neutral-200 overflow-hidden">
            <div class="overflow-x-auto">
                <table class="w-full">
                    <thead class="bg-neutral-900 text-white">
                    <tr>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Name</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Last Name</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Phone</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Gender</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Blood Type</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Weight (kg)</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">CIN</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Associated Receivers</th>
                        <th class="px-6 py-4 text-left text-sm font-semibold">Blood Type</th>
                        <th class="px-6 py-4 text-center text-sm font-semibold">Actions</th>
                    </tr>
                    </thead>
                    <tbody class="divide-y divide-neutral-200">
                    <c:forEach var="row" items="${donations}">
                        <tr class="hover:bg-neutral-50 transition-colors">
                            <!-- Donor info -->
                            <td><c:out value="${row[0].name}"/></td>
                            <td><c:out value="${row[0].lastname}"/></td>
                            <td><c:out value="${row[0].phone}"/></td>
                            <td><c:out value="${row[0].gender}"/></td>
                            <td>
            <span class="inline-flex items-center px-3 py-1 rounded-full text-xs font-medium bg-red-100 text-red-800">
                <c:out value="${row[0].bloodtype}"/>
            </span>
                            </td>
                            <td><c:out value="${row[0].weith}"/></td>
                            <td><c:out value="${row[0].cin}"/></td>

                            <!-- Recipient info -->
                            <td><c:out value="${row[1].name} ${row[1].lastname}"/></td>
                            <td>
            <span class="inline-flex items-center px-3 py-1 rounded-full text-xs font-medium bg-red-100 text-red-800">
                <c:out value="${row[1].bloodType}"/>
            </span>
                            </td>

                            <!-- Actions -->
                            <td>
                                <div class="flex items-center justify-center gap-2">
                                    <button class="px-3 py-1.5 text-xs font-medium text-neutral-700 hover:text-neutral-900 hover:bg-neutral-100 rounded transition-all">View</button>
                                    <button class="px-3 py-1.5 text-xs font-medium text-neutral-700 hover:text-neutral-900 hover:bg-neutral-100 rounded transition-all">Edit</button>
                                    <button class="px-3 py-1.5 text-xs font-medium text-red-600 hover:text-red-700 hover:bg-red-50 rounded transition-all">Delete</button>
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
