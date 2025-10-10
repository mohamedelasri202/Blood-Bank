
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Request - LifeStream Blood Bank</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@300;400;500;600;700&family=Inter:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        .font-serif { font-family: 'Cormorant Garamond', serif; }
        .font-sans { font-family: 'Inter', sans-serif; }
    </style>
</head>
<body class="font-sans bg-neutral-50 min-h-screen">

<nav class="fixed w-full z-50 bg-white/95 backdrop-blur-sm border-b border-neutral-200">
    <div class="max-w-7xl mx-auto px-6 lg:px-8">
        <div class="flex justify-between items-center h-20">

            <div class="flex items-center gap-3">
                <img src="${pageContext.request.contextPath}/images/logo.webp?height=50&width=50" alt="LifeStream Logo" class="h-12 w-12 rounded-full object-cover border-2 border-red-900/20">

            </div>


            <div class="hidden md:flex items-center gap-8">
                <a href="index.html" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">Home</a>
                <a href="#" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">About</a>
                <a href="#" class="text-neutral-600 hover:text-neutral-900 transition-colors text-sm font-medium">Contact</a>
                <a href="donor-form.html" class="px-6 py-2.5 bg-red-900 text-white text-sm font-medium hover:bg-red-800 transition-colors">Donate Now</a>
                <a href="receiver-form.html" class="px-6 py-2.5 border-2 border-red-900 text-red-900 text-sm font-medium hover:bg-red-900 hover:text-white transition-colors">Request Blood</a>
            </div>
        </div>
    </div>
</nav>


<div class="pt-32 pb-20 px-6">
    <div class="max-w-3xl mx-auto">

        <div class="text-center mb-12">
            <h1 class="font-serif text-5xl md:text-6xl font-light text-neutral-900 mb-4">Blood Request</h1>
            <p class="text-neutral-600 text-lg leading-relaxed max-w-2xl mx-auto">
                We're here to help. Please fill out the form below to request blood for yourself or a loved one.
            </p>
        </div>


        <form class="bg-white rounded-lg shadow-sm border border-neutral-200 p-8 md:p-12" action="${pageContext.request.contextPath}/addreceiver" method="post">
            <div class="grid grid-cols-1 md:grid-cols-2 gap-6">

                <div>
                    <label for="name" class="block text-sm font-medium text-neutral-900 mb-2">First Name</label>
                    <input type="text" id="name" name="name" required
                           class="w-full px-4 py-3 border border-neutral-300 rounded-md focus:ring-2 focus:ring-red-900 focus:border-transparent outline-none transition-all">
                </div>


                <div>
                    <label for="lastname" class="block text-sm font-medium text-neutral-900 mb-2">Last Name</label>
                    <input type="text" id="lastname" name="lastname" required
                           class="w-full px-4 py-3 border border-neutral-300 rounded-md focus:ring-2 focus:ring-red-900 focus:border-transparent outline-none transition-all">
                </div>


                <div>
                    <label for="phone" class="block text-sm font-medium text-neutral-900 mb-2">Phone Number</label>
                    <input type="tel" id="phone" name="phone" required
                           class="w-full px-4 py-3 border border-neutral-300 rounded-md focus:ring-2 focus:ring-red-900 focus:border-transparent outline-none transition-all">
                </div>


                <div>
                    <label for="gender" class="block text-sm font-medium text-neutral-900 mb-2">Gender</label>
                    <select id="gender" name="gender" required
                            class="w-full px-4 py-3 border border-neutral-300 rounded-md focus:ring-2 focus:ring-red-900 focus:border-transparent outline-none transition-all bg-white">
                        <option value="">Select Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>

                    </select>
                </div>

                <div>
                    <label for="dob" class="block text-sm font-medium text-neutral-900 mb-2">Date of Birth</label>
                    <input type="date" id="dob" name="date_of_birth" required
                           class="w-full px-4 py-3 border border-neutral-300 rounded-md focus:ring-2 focus:ring-red-900 focus:border-transparent outline-none transition-all">
                </div>


                <div>
                    <label for="cin" class="block text-sm font-medium text-neutral-900 mb-2">CIN (National ID)</label>
                    <input type="text" id="cin" name="cin" required
                           class="w-full px-4 py-3 border border-neutral-300 rounded-md focus:ring-2 focus:ring-red-900 focus:border-transparent outline-none transition-all">
                </div>


                <div>
                    <label for="bloodtype" class="block text-sm font-medium text-neutral-900 mb-2">Blood Type Needed</label>
                    <select id="bloodtype" name="bloodtype" required
                            class="w-full px-4 py-3 border border-neutral-300 rounded-md focus:ring-2 focus:ring-red-900 focus:border-transparent outline-none transition-all bg-white">
                        <option value="">Select Blood Type</option>
                        <option value="A_positive">A+</option>
                        <option value="A_negative">A-</option>
                        <option value="B_positive">B+</option>
                        <option value="B_negative">B-</option>
                        <option value="AB_positive">AB+</option>
                        <option value="AB_negative">AB-</option>
                        <option value="O_positive">O+</option>
                        <option value="O_negative">O-</option>
                    </select>
                </div>


                <div>
                    <label for="urgency" class="block text-sm font-medium text-neutral-900 mb-2">Urgency Level</label>
                    <select id="urgency" name="urgency" required
                            class="w-full px-4 py-3 border border-neutral-300 rounded-md focus:ring-2 focus:ring-red-900 focus:border-transparent outline-none transition-all bg-white">
                        <option value="">Select Urgency</option>
                        <option value="CRITICAL">Critical</option>
                        <option value="URGENT">Urgent</option>
                        <option value="NORMAL">Normal</option>
                    </select>
                </div>
            </div>


            <div class="mt-8">
                <button type="submit"
                        class="w-full px-8 py-4 bg-red-900 text-white text-base font-medium hover:bg-red-800 transition-colors rounded-md">
                    Submit Request
                </button>
            </div>

   
            <p class="text-sm text-neutral-500 text-center mt-6">
                Our team will review your request and contact you as soon as possible.
            </p>
        </form>
    </div>
</div>
</body>
</html>

