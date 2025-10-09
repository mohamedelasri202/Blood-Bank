<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Bank Services - Welcome</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@300;400;500;600&family=Inter:wght@300;400;500&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Inter', sans-serif;
        }
        .heading-font {
            font-family: 'Cormorant Garamond', serif;
        }
    </style>
</head>
<body class="antialiased">

<div class="relative min-h-screen w-full bg-cover bg-center bg-no-repeat" style="background-image: url('/placeholder.svg?height=1080&width=1920');">


    <div class="absolute inset-0 bg-gradient-to-b from-black/60 via-black/40 to-black/70"></div>


    <div class="relative z-10 flex flex-col min-h-screen">


        <nav class="px-6 py-8 md:px-12 lg:px-16">
            <div class="max-w-7xl mx-auto flex items-center justify-between">

                <div class="flex items-center">
                    <img src="${pageContext.request.contextPath}/images/logo.webp?height=60&width=60" alt="LifeStream Logo" class="w-12 h-12 md:w-14 md:h-14 rounded-full object-cover border-2 border-white/20">
                </div>


                <div class="hidden md:flex items-center gap-8 lg:gap-12">
                    <a href="#" class="text-white/90 hover:text-white text-sm font-light tracking-wider transition-colors duration-300">Services</a>
                    <a href="#" class="text-white/90 hover:text-white text-sm font-light tracking-wider transition-colors duration-300">About</a>
                    <a href="#" class="text-white/90 hover:text-white text-sm font-light tracking-wider transition-colors duration-300">Contact</a>
                    <a href="views/receiverForm.jsp" class="px-6 py-2.5 bg-white/10 backdrop-blur-sm border border-white/20 text-white text-sm font-light tracking-wider hover:bg-white/20 transition-all duration-300">
                        Request Blood
                    </a>
                    <a href="views/donorForm.jsp" class="px-6 py-2.5 bg-white/10 backdrop-blur-sm border border-white/20 text-white text-sm font-light tracking-wider hover:bg-white/20 transition-all duration-300">
                        Donate Now
                    </a>
                </div>


                <button class="md:hidden text-white">
                    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5" d="M4 6h16M4 12h16M4 18h16"></path>
                    </svg>
                </button>
            </div>
        </nav>


        <main class="flex-1 flex items-center justify-center px-6 md:px-12 lg:px-16 pb-16">
            <div class="max-w-4xl mx-auto text-center">


                <div class="w-16 h-px bg-white/40 mx-auto mb-8"></div>


                <h1 class="heading-font text-5xl md:text-6xl lg:text-7xl font-light text-white mb-6 leading-tight tracking-wide">
                    Every Drop<br/>Saves a Life
                </h1>


                <p class="text-white/80 text-lg md:text-xl font-light max-w-2xl mx-auto mb-12 leading-relaxed tracking-wide">
                    Join our mission to provide life-saving blood services with dignity, care, and excellence
                </p>


                <div class="flex flex-col sm:flex-row items-center justify-center gap-4 sm:gap-6">
                    <a href="#" class="w-full sm:w-auto px-10 py-4 bg-white text-black text-sm font-medium tracking-widest hover:bg-white/90 transition-all duration-300 uppercase">
                        Get Started
                    </a>
                    <a href="#" class="w-full sm:w-auto px-10 py-4 bg-transparent border border-white/30 backdrop-blur-sm text-white text-sm font-light tracking-widest hover:bg-white/10 transition-all duration-300 uppercase">
                        Learn More
                    </a>
                </div>


                <div class="mt-20 grid grid-cols-3 gap-8 max-w-3xl mx-auto">
                    <div class="text-center">
                        <div class="heading-font text-4xl md:text-5xl font-light text-white mb-2">10K+</div>
                        <div class="text-white/60 text-xs md:text-sm font-light tracking-wider uppercase">Lives Saved</div>
                    </div>
                    <div class="text-center border-x border-white/20">
                        <div class="heading-font text-4xl md:text-5xl font-light text-white mb-2">24/7</div>
                        <div class="text-white/60 text-xs md:text-sm font-light tracking-wider uppercase">Available</div>
                    </div>
                    <div class="text-center">
                        <div class="heading-font text-4xl md:text-5xl font-light text-white mb-2">500+</div>
                        <div class="text-white/60 text-xs md:text-sm font-light tracking-wider uppercase">Donors</div>
                    </div>
                </div>

            </div>
        </main>

    </div>
</div>
</body>
</html>
