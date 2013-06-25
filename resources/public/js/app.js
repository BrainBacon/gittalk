Reveal.initialize({
    controls: true,
    progress: true,
    history: true,
    center: true,

    theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
    transition: Reveal.getQueryHash().transition || 'default', // default/cube/page/concave/zoom/linear/fade/none

    // Optional libraries used to extend on reveal.js
    dependencies: [
        { src: context + '/js/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
        { src: context + '/js/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
        { src: context + '/js/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },
    ]
});
