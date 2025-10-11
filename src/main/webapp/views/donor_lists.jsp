<%@ page import="com.bloodbank.model.BloodType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
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

<%--the blood dype --%>
<%
    BloodType bloodtype = (BloodType)session.getAttribute("donorBloodtype");
%>
<nav class="fixed w-full z-50 bg-white/80 backdrop-blur-md border-b border-stone-200">
    <div class="max-w-7xl mx-auto px-6 lg:px-8">
        <div class="flex justify-between items-center h-20">

            <div class="flex items-center gap-3">
                <img src="${pageContext.request.contextPath}/images/logo.webp" alt="LifeStream Logo" class="h-12 w-12 rounded-full object-cover border-2 border-rose-200">

            </div>


            <div class="hidden md:flex items-center gap-8">
                <a href="index.html" class="text-stone-600 hover:text-rose-600 transition-colors text-sm font-medium tracking-wide">Home</a>
                <a href="donors-list.html" class="text-stone-600 hover:text-rose-600 transition-colors text-sm font-medium tracking-wide">Donors</a>
                <a href="recipients-list.html" class="text-stone-600 hover:text-rose-600 transition-colors text-sm font-medium tracking-wide">Recipients</a>
                <a href="donor-form.html" class="px-6 py-2.5 bg-rose-600 text-white rounded-full hover:bg-rose-700 transition-all text-sm font-medium tracking-wide">Donate Now</a>
                <a href="receiver-form.html" class="px-6 py-2.5 bg-stone-800 text-white rounded-full hover:bg-stone-900 transition-all text-sm font-medium tracking-wide">Request Blood</a>
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

                <span class="px-4 py-1 bg-rose-600 text-white rounded-full text-sm font-semibold"><%=bloodtype%></span>
            </div>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">

            <div class="bg-white rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 overflow-hidden border border-stone-200">
                <div class="p-8">
                    <div class="flex items-center justify-between mb-6">
                            <span class="px-4 py-1.5 bg-red-100 text-red-700 rounded-full text-xs font-semibold uppercase tracking-wide">
                                Critical
                            </span>
                        <span class="px-4 py-1.5 bg-rose-600 text-white rounded-full text-sm font-semibold">
                                A+
                            </span>
                    </div>


                    <div class="mb-6">
                        <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-2">
                            Sarah Johnson
                        </h3>
                        <div class="space-y-2 text-sm text-stone-600">
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Status:</span>
                                <span class="px-3 py-1 bg-amber-100 text-amber-700 rounded-full text-xs font-semibold">
                                        Not Satisfied
                                    </span>
                            </div>
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Blood Type:</span>
                                <span class="font-semibold text-stone-800">A+</span>
                            </div>
                        </div>
                    </div>


                    <button class="w-full py-3 bg-rose-600 text-white rounded-full hover:bg-rose-700 transition-all font-medium tracking-wide shadow-md hover:shadow-lg">
                        Donate Now
                    </button>
                </div>
            </div>


            <div class="bg-white rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 overflow-hidden border border-stone-200">
                <div class="p-8">

                    <div class="flex items-center justify-between mb-6">
                            <span class="px-4 py-1.5 bg-orange-100 text-orange-700 rounded-full text-xs font-semibold uppercase tracking-wide">
                                Urgent
                            </span>
                        <span class="px-4 py-1.5 bg-rose-600 text-white rounded-full text-sm font-semibold">
                                A+
                            </span>
                    </div>


                    <div class="mb-6">
                        <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-2">
                            Michael Chen
                        </h3>
                        <div class="space-y-2 text-sm text-stone-600">
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Status:</span>
                                <span class="px-3 py-1 bg-amber-100 text-amber-700 rounded-full text-xs font-semibold">
                                        Not Satisfied
                                    </span>
                            </div>
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Blood Type:</span>
                                <span class="font-semibold text-stone-800">A+</span>
                            </div>
                        </div>
                    </div>


                    <button class="w-full py-3 bg-rose-600 text-white rounded-full hover:bg-rose-700 transition-all font-medium tracking-wide shadow-md hover:shadow-lg">
                        Donate Now
                    </button>
                </div>
            </div>


            <div class="bg-white rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 overflow-hidden border border-stone-200">
                <div class="p-8">

                    <div class="flex items-center justify-between mb-6">
                            <span class="px-4 py-1.5 bg-emerald-100 text-emerald-700 rounded-full text-xs font-semibold uppercase tracking-wide">
                                Normal
                            </span>
                        <span class="px-4 py-1.5 bg-rose-600 text-white rounded-full text-sm font-semibold">
                                A+
                            </span>
                    </div>

                    <div class="mb-6">
                        <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-2">
                            Emma Williams
                        </h3>
                        <div class="space-y-2 text-sm text-stone-600">
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Status:</span>
                                <span class="px-3 py-1 bg-amber-100 text-amber-700 rounded-full text-xs font-semibold">
                                        Not Satisfied
                                    </span>
                            </div>
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Blood Type:</span>
                                <span class="font-semibold text-stone-800">A+</span>
                            </div>
                        </div>
                    </div>


                    <button class="w-full py-3 bg-rose-600 text-white rounded-full hover:bg-rose-700 transition-all font-medium tracking-wide shadow-md hover:shadow-lg">
                        Donate Now
                    </button>
                </div>
            </div>


            <div class="bg-white rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 overflow-hidden border border-stone-200">
                <div class="p-8">

                    <div class="flex items-center justify-between mb-6">
                            <span class="px-4 py-1.5 bg-red-100 text-red-700 rounded-full text-xs font-semibold uppercase tracking-wide">
                                Critical
                            </span>
                        <span class="px-4 py-1.5 bg-rose-600 text-white rounded-full text-sm font-semibold">
                                A-
                            </span>
                    </div>


                    <div class="mb-6">
                        <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-2">
                            David Martinez
                        </h3>
                        <div class="space-y-2 text-sm text-stone-600">
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Status:</span>
                                <span class="px-3 py-1 bg-amber-100 text-amber-700 rounded-full text-xs font-semibold">
                                        Not Satisfied
                                    </span>
                            </div>
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Blood Type:</span>
                                <span class="font-semibold text-stone-800">A-</span>
                            </div>
                        </div>
                    </div>


                    <button class="w-full py-3 bg-rose-600 text-white rounded-full hover:bg-rose-700 transition-all font-medium tracking-wide shadow-md hover:shadow-lg">
                        Donate Now
                    </button>
                </div>
            </div>


            <div class="bg-white rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 overflow-hidden border border-stone-200">
                <div class="p-8">

                    <div class="flex items-center justify-between mb-6">
                            <span class="px-4 py-1.5 bg-orange-100 text-orange-700 rounded-full text-xs font-semibold uppercase tracking-wide">
                                Urgent
                            </span>
                        <span class="px-4 py-1.5 bg-rose-600 text-white rounded-full text-sm font-semibold">
                                A-
                            </span>
                    </div>


                    <div class="mb-6">
                        <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-2">
                            Lisa Anderson
                        </h3>
                        <div class="space-y-2 text-sm text-stone-600">
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Status:</span>
                                <span class="px-3 py-1 bg-emerald-100 text-emerald-700 rounded-full text-xs font-semibold">
                                        Satisfied
                                    </span>
                            </div>
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Blood Type:</span>
                                <span class="font-semibold text-stone-800">A-</span>
                            </div>
                        </div>
                    </div>


                    <button class="w-full py-3 bg-stone-300 text-stone-500 rounded-full cursor-not-allowed font-medium tracking-wide" disabled>
                        Already Satisfied
                    </button>
                </div>
            </div>


            <div class="bg-white rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 overflow-hidden border border-stone-200">
                <div class="p-8">
                    <div class="flex items-center justify-between mb-6">
                            <span class="px-4 py-1.5 bg-emerald-100 text-emerald-700 rounded-full text-xs font-semibold uppercase tracking-wide">
                                Normal
                            </span>
                        <span class="px-4 py-1.5 bg-rose-600 text-white rounded-full text-sm font-semibold">
                                A+
                            </span>
                    </div>


                    <div class="mb-6">
                        <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-2">
                            James Taylor
                        </h3>
                        <div class="space-y-2 text-sm text-stone-600">
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Status:</span>
                                <span class="px-3 py-1 bg-amber-100 text-amber-700 rounded-full text-xs font-semibold">
                                        Not Satisfied
                                    </span>
                            </div>
                            <div class="flex items-center justify-between">
                                <span class="font-medium">Blood Type:</span>
                                <span class="font-semibold text-stone-800">A+</span>
                            </div>
                        </div>
                    </div>


                    <button class="w-full py-3 bg-rose-600 text-white rounded-full hover:bg-rose-700 transition-all font-medium tracking-wide shadow-md hover:shadow-lg">
                        Donate Now
                    </button>
                </div>
            </div>
        </div>


        <div class="hidden text-center py-20">
            <div class="max-w-md mx-auto">
                <div class="w-24 h-24 bg-stone-100 rounded-full flex items-center justify-center mx-auto mb-6">
                    <svg class="w-12 h-12 text-stone-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12h6m-6 4h6m2 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"></path>
                    </svg>
                </div>
                <h3 class="font-serif text-2xl font-semibold text-stone-800 mb-3">No Recipients Available</h3>
                <p class="text-stone-600 leading-relaxed">There are currently no recipients with compatible blood types waiting for donations.</p>
            </div>
        </div>
    </div>
</main>
</body>
</html>
