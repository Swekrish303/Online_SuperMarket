const tabs = document.querySelectorAll('.tabs__btn');
const tabsContent = document.querySelectorAll('.tabs__body');

if (tabsContent.length > 0 || tabs.length > 0) {

    function hideTabContent() {
        tabsContent.forEach(item => {
            item.classList.remove('active');
        });

        tabs.forEach(item => {
            item.classList.remove('active');
        });
    }

    function showTabContent(i = 0) {
        tabsContent[i].classList.add('active');
        tabs[i].classList.add('active');
    }

    hideTabContent();
    showTabContent();

    tabs.forEach((tab, index) => {
        tab.addEventListener('click', () => {
            hideTabContent();
            showTabContent(index);
        });
    });
}