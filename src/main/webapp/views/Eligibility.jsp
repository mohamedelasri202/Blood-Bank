
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Donation Eligibility - LifeStream Blood Bank</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@300;400;500;600;700&family=Inter:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        .font-serif { font-family: 'Cormorant Garamond', serif; }
        .font-sans { font-family: 'Inter', sans-serif; }
    </style>
</head>
<body class="font-sans bg-gradient-to-br from-slate-50 via-white to-slate-100 min-h-screen">

<nav class="fixed w-full top-0 z-50 bg-white/80 backdrop-blur-md border-b border-slate-200/50">
    <div class="max-w-7xl mx-auto px-6 lg:px-8">
        <div class="flex justify-between items-center h-20">
            Logo
            <div class="flex items-center space-x-3">
                <img src="/${pageContext.request.contextPath}/images/logo.webp" alt="LifeStream Logo" class="w-12 h-12 rounded-full object-cover border-2 border-red-600/20">
                <span class="font-serif text-2xl font-semibold text-slate-900">LifeStream</span>
            </div>


            <div class="hidden md:flex items-center space-x-8">
                <a href="index.html" class="text-slate-600 hover:text-slate-900 transition-colors duration-300 text-sm font-medium tracking-wide">Home</a>
                <a href="#" class="text-slate-600 hover:text-slate-900 transition-colors duration-300 text-sm font-medium tracking-wide">About</a>
                <a href="#" class="text-slate-600 hover:text-slate-900 transition-colors duration-300 text-sm font-medium tracking-wide">Contact</a>
            </div>


            <div class="flex items-center space-x-4">
                <a href="receiver-form.html" class="hidden md:inline-block px-6 py-2.5 text-slate-700 hover:text-slate-900 transition-all duration-300 text-sm font-medium tracking-wide border border-slate-300 rounded-full hover:border-slate-400">
                    Request Blood
                </a>
                <a href="donor-form.html" class="px-6 py-2.5 bg-red-600 text-white rounded-full hover:bg-red-700 transition-all duration-300 text-sm font-medium tracking-wide shadow-lg shadow-red-600/30">
                    Donate Now
                </a>
            </div>
        </div>
    </div>
</nav>


<main class="pt-32 pb-20 px-6">
    <div class="max-w-4xl mx-auto">

        <div class="text-center mb-12">
            <div class="inline-flex items-center justify-center w-20 h-20 rounded-full bg-amber-100 mb-6">
                <svg class="w-10 h-10 text-amber-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 9v2m0 4h.01m-6.938 4h13.856c1.54 0 2.502-1.667 1.732-3L13.732 4c-.77-1.333-2.694-1.333-3.464 0L3.34 16c-.77 1.333.192 3 1.732 3z"/>
                </svg>
            </div>
            <h1 class="font-serif text-5xl font-bold text-slate-900 mb-4">Donation Eligibility Notice</h1>
            <p class="text-xl text-slate-600 max-w-2xl mx-auto leading-relaxed">
                Thank you for your willingness to donate. Unfortunately, you are currently not eligible to donate blood.
            </p>
        </div>

        <div class="bg-white rounded-2xl shadow-xl shadow-slate-200/50 border border-slate-200/50 overflow-hidden mb-8">
            <div class="bg-gradient-to-r from-red-600 to-red-700 px-8 py-6">
                <h2 class="font-serif text-3xl font-semibold text-white">Eligibility Criteria</h2>
                <p class="text-red-100 mt-2">A donor is considered <span class="font-semibold text-white">NOT ELIGIBLE</span> if they do not meet the following requirements:</p>
            </div>

            <div class="p-8">
                <div class="space-y-6">
                    Age Requirement
                    <div class="flex items-start space-x-4 p-4 rounded-xl bg-slate-50 border border-slate-200/50">
                        <div class="flex-shrink-0 w-10 h-10 rounded-full bg-red-100 flex items-center justify-center">
                            <svg class="w-5 h-5 text-red-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"/>
                            </svg>
                        </div>
                        <div>
                            <h3 class="font-semibold text-slate-900 text-lg mb-1">Age Requirement</h3>
                            <p class="text-slate-600">Must be between <span class="font-semibold text-slate-900">18 and 65 years old</span></p>
                        </div>
                    </div>


                    <div class="flex items-start space-x-4 p-4 rounded-xl bg-slate-50 border border-slate-200/50">
                        <div class="flex-shrink-0 w-10 h-10 rounded-full bg-red-100 flex items-center justify-center">
                            <svg class="w-5 h-5 text-red-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 6l3 1m0 0l-3 9a5.002 5.002 0 006.001 0M6 7l3 9M6 7l6-2m6 2l3-1m-3 1l-3 9a5.002 5.002 0 006.001 0M18 7l3 9m-3-9l-6-2m0-2v2m0 16V5m0 16H9m3 0h3"/>
                            </svg>
                        </div>
                        <div>
                            <h3 class="font-semibold text-slate-900 text-lg mb-1">Minimum Weight</h3>
                            <p class="text-slate-600">Must weigh at least <span class="font-semibold text-slate-900">50 kg (110 lbs)</span></p>
                        </div>
                    </div>


                    <div class="flex items-start space-x-4 p-4 rounded-xl bg-slate-50 border border-slate-200/50">
                        <div class="flex-shrink-0 w-10 h-10 rounded-full bg-red-100 flex items-center justify-center">
                            <svg class="w-5 h-5 text-red-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12h6m-6 4h6m2 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"/>
                            </svg>
                        </div>
                        <div class="flex-1">
                            <h3 class="font-semibold text-slate-900 text-lg mb-3">No Medical Contraindications</h3>
                            <p class="text-slate-600 mb-3">Must not have any of the following conditions:</p>
                            <ul class="space-y-2">
                                <li class="flex items-center text-slate-700">
                                    <span class="w-1.5 h-1.5 rounded-full bg-red-600 mr-3"></span>
                                    Hepatitis B or C
                                </li>
                                <li class="flex items-center text-slate-700">
                                    <span class="w-1.5 h-1.5 rounded-full bg-red-600 mr-3"></span>
                                    HIV/AIDS
                                </li>
                                <li class="flex items-center text-slate-700">
                                    <span class="w-1.5 h-1.5 rounded-full bg-red-600 mr-3"></span>
                                    Insulin-dependent diabetes
                                </li>
                                <li class="flex items-center text-slate-700">
                                    <span class="w-1.5 h-1.5 rounded-full bg-red-600 mr-3"></span>
                                    Currently pregnant
                                </li>
                                <li class="flex items-center text-slate-700">
                                    <span class="w-1.5 h-1.5 rounded-full bg-red-600 mr-3"></span>
                                    Currently breastfeeding
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <div class="text-center mt-12">
            <p class="text-slate-600 mb-6">Have questions about your eligibility status?</p>
            <a href="#" class="inline-block px-8 py-3 bg-slate-900 text-white rounded-full hover:bg-slate-800 transition-all duration-300 font-medium tracking-wide shadow-lg shadow-slate-900/30">
                Contact Us
            </a>
        </div>
    </div>
</main>
</body>
</html>

