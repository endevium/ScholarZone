// Animation ng container
function animateCount(element, target, duration = 2000) {
    let start = 0;
    const increment = target / (duration / 16);
    const timer = setInterval(() => {
        start += increment;
        element.textContent = Math.floor(start);
        if (start >= target) {
            element.textContent = target;
            clearInterval(timer);
            }
        }, 16);
    }

// counter
window.addEventListener('load', () => {
    animateCount(document.getElementById('respondentsCount'), 147);
    animateCount(document.getElementById('pendingCount'), 91);
    animateCount(document.getElementById('formsCount'), 300);
});

// Mobile menu toggle pag binuksan sa mobile may lalabas na menu
const avatarIcon = document.getElementById("avatar-icon");
const hoverProfile = document.getElementById("hover-profile");

avatarIcon.addEventListener("click", function (event) {
    hoverProfile.classList.toggle("show");
    event.stopPropagation();
});

document.addEventListener("click", function (event) {
    if (!hoverProfile.contains(event.target) && event.target !== avatarIcon) {
        hoverProfile.classList.remove("show");
    }
});

const sidebar = document.getElementById("sidebar");
menuToggle.addEventListener("click", function () {
    sidebar.classList.toggle("show");
});

const closeBtn = document.getElementById("close");
closeBtn.addEventListener("click", function () {
    sidebar.classList.remove("show");
});

// Charts
// Progress Chart
const progressCtx = document.getElementById('progressChart').getContext('2d');
        new Chart(progressCtx, {
            type: 'doughnut',
            data: {
                labels: ['Completed', 'Pending'],
                datasets: [{
                    data: [38.03, 61.97],
                    backgroundColor: ['#9ca3af', '#2563eb'],
                    borderWidth: 0
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                cutout: '70%',
                plugins: {
                    legend: {
                        display: false
                    },
                    tooltip: {
                        callbacks: {
                            label: function(context) {
                                return `${context.raw}%`;
                            }
                        }
                    }
                }
            }
        });

        
// Bar Chart
const timeCtx = document.getElementById('timeChart').getContext('2d');
new Chart(timeCtx, {
    type: 'bar',
    data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
        datasets: [{
            label: 'Average Review Time (hours)',
            data: [4, 4, 2.5, 4, 2, 2.5],
            backgroundColor: '#2563eb',
            borderRadius: 4
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
            y: {
                beginAtZero: true,
                max: 5,
                ticks: {
                    stepSize: 0.5
                },
                grid: {
                    color: '#e5e7eb'
                }
            },
            x: {
                grid: {
                    display: false
                }
            }
        },
        plugins: {
            legend: {
                display: false
            }
        }
    }
});