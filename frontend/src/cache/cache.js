export function saveToCache(key, data) {
    localStorage.setItem(key, JSON.stringify({
        data,
        timestamp: Date.now()
    }));
}

export function loadFromCache(key, maxAge) {
    const cached = localStorage.getItem(key);
    if (!cached) return null;
    try {
        return JSON.parse(cached).data;
    } catch {
        return null;
    }
}