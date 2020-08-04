<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
     width="${label_width + message_width}" height="20">
    <linearGradient id="smooth" x2="0" y2="100%">
        <stop offset="0" stop-color="#bbb" stop-opacity=".1"/>
        <stop offset="1" stop-opacity=".1"/>
    </linearGradient>

    <mask id="round">
        <rect width="${label_width + message_width}" height="20" rx="3" fill="#fff"/>
    </mask>

    <g mask="url(#round)">
        <rect width="${label_width}" height="20" fill="${label_color}"/>
        <rect x="${label_width}" width="${message_width}" height="20" fill="${message_color}"/>
        <rect width="${label_width + message_width}" height="20" fill="url(#smooth)"/>
    </g>

    <g fill="#fff" text-anchor="middle" font-family="DejaVu Sans,Verdana,Geneva,sans-serif" font-size="11">
        <text x="${label_width/2}" y="15" fill="#010101" fill-opacity=".3">${label_text}</text>
        <text x="${label_width/2}" y="14">${label_text}</text>
        <text x="${label_width + message_width/2-1}" y="15" fill="#010101" fill-opacity=".3">${message_text}</text>
        <text x="${label_width + message_width/2-1}" y="14">${message_text}</text>
    </g>
</svg>
