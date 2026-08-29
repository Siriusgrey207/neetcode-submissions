class TimeMap {
public:
    std::unordered_map<std::string, std::vector<std::pair<int, std::string>>> keyStore {};

    TimeMap() {}
    
    void set(std::string key, std::string value, int timestamp) {
        keyStore[key].emplace_back(std::pair<int, std::string> { timestamp, value });
    }
    
    std::string get(std::string key, int timestamp) {
        auto& values = keyStore[key];
        int left = 0;
        int right = values.size() - 1;
        std::string res { "" };

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (values[mid].first <= timestamp) {
                res = values[mid].second;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
};
