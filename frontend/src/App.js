import React, { useState } from 'react';
import './App.css';

function App() {
    const [isExpert, setIsExpert] = useState(false); // Theo dõi nếu người dùng là chuyên gia
    const [isMaster, setIsMaster] = useState(false); // Theo dõi nếu người dùng đạt mốc Master

    const tests = [
        { name: "ELITS - Test 1", duration: "10 phút", questions: 30 },
        { name: "ELITS - Test 2", duration: "15 phút", questions: 25 },
        { name: "ELITS - Test 3", duration: "12 phút", questions: 35 },
        { name: "ELITS - Test 4", duration: "10 phút", questions: 20 },
        { name: "ELITS - Test 5", duration: "20 phút", questions: 40 },
        { name: "ELITS - Test 6", duration: "15 phút", questions: 30 },
        { name: "ELITS - Test 7", duration: "12 phút", questions: 35 },
        { name: "ELITS - Test 8", duration: "10 phút", questions: 25 },
        { name: "ELITS - Test 9", duration: "20 phút", questions: 40 },
        { name: "ELITS - Test 10", duration: "15 phút", questions: 30 },
        { name: "ELITS - Test 11", duration: "10 phút", questions: 20 },
        { name: "ELITS - Test 12", duration: "18 phút", questions: 35 },
        { name: "ELITS - Test 13", duration: "12 phút", questions: 30 },
        { name: "ELITS - Test 14", duration: "10 phút", questions: 25 },
        { name: "ELITS - Test 15", duration: "20 phút", questions: 40 }
    ];

    const achievements = [
        {
            name: "Newbie",
            progress: 0,
            total: 5,
            description: "Hoàn thành 5 bài kiểm tra",
            reward: "Nhận mốc Newbie NFT",
        },
        {
            name: "Thực tập sinh",
            progress: 5,
            total: 10,
            description: "Hoàn thành 10 bài kiểm tra",
            reward: "Nhận mốc Thực tập sinh NFT",
        },
        {
            name: "Junior",
            progress: 10,
            total: 15,
            description: "Hoàn thành 15 bài kiểm tra",
            reward: "Nhận mốc Junior NFT",
        },
        {
            name: "Chuyên gia",
            progress: 15,
            total: 20,
            description: "Hoàn thành 20 bài kiểm tra",
            reward: "Nhận mốc Chuyên gia NFT & quyền tạo job nhỏ phiên dịch",
        },
        {
            name: "Master",
            progress: 20,
            total: 25,
            description: "Hoàn thành 25 bài kiểm tra",
            reward: "Nhận mốc Master NFT & quyền truy cập vào các thử thách cao cấp",
        },
    ];

    const createJob = () => {
        if (!isExpert) {
            alert('Bạn cần đạt mốc "Chuyên gia" để tạo job nhỏ phiên dịch!');
            return;
        }

        alert('Job phiên dịch đã được tạo! Hệ thống trả thưởng đã sẵn sàng!');
    };

    const accessAdvancedFeatures = () => {
        if (!isMaster) {
            alert('Bạn cần đạt mốc "Master" để truy cập các tính năng nâng cao!');
            return;
        }

        alert('Truy cập tính năng nâng cao đã được mở!');
    };

    const registerTutor = () => {
        if (!isMaster) {
            alert('Bạn cần đạt mốc "Master" để đăng ký gia sư đi dạy!');
            return;
        }

        alert('Bạn đã đăng ký thành công gia sư đi dạy!');
    };

    const handleAchievement = (achievement) => {
        if (achievement.name === "Chuyên gia" && achievement.progress >= achievement.total) {
            setIsExpert(true);
        }

        // Kiểm tra mốc "Master" và mở quyền truy cập tính năng
        if (achievement.name === "Master" && achievement.progress >= achievement.total) {
            setIsMaster(true);
        }
    };

    return (
        <div className="container">
            <h1 className="title">DANH SÁCH ĐỀ THI</h1>
            <div className="test-card-container">
                {tests.map((test, index) => (
                    <div key={index} className="test-card">
                        <h2>{test.name}</h2>
                        <p>🕑 {test.duration}</p>
                        <p>📄 {test.questions} câu hỏi</p>
                        <button className="start-button">LÀM BÀI</button>
                    </div>
                ))}
            </div>

            <h4 className="title">Thành tích</h4>
            <div className="achievement-list">
                {achievements.map((achievement, index) => (
                    <div key={index} className="achievement-card">
                        <h3>{achievement.name}</h3>
                        <p>{achievement.description}</p>
                        <div className="progress-bar-container">
                            <div
                                className="progress-bar"
                                style={{ width: `${(achievement.progress / achievement.total) * 100}%` }}
                            ></div>
                        </div>
                        <p>{achievement.progress}/{achievement.total}</p>

                        {achievement.progress >= achievement.total && (
                            <div className="reward">
                                🌟 <strong>Quyền hạn:</strong> {achievement.reward}
                            </div>
                        )}

                        {achievement.name === "Chuyên gia" && achievement.progress >= achievement.total && (
                            <button onClick={createJob} className="create-job-button">
                                Tạo Job Phiên Dịch
                            </button>
                        )}

                        {achievement.name === "Master" && achievement.progress >= achievement.total && (
                            <>/-strong/-heart:>:o:-((:-h <button onClick={accessAdvancedFeatures} className="access-advanced-button">
                                Truy cập Tính Năng Nâng Cao
                            </button>
                                <button onClick={registerTutor} className="register-tutor-button">
                                    Đăng Ký Gia Sư Đi Dạy
                                </button>
                            </>
                        )}
                    </div>
                ))}
            </div>
        </div>
    );
}

export default App;