import React from 'react';
import './App.css';

function App() {
  const tests = [
    { name: "English Test", duration: "10 phút", questions: 30 },
    { name: "Math Test", duration: "10 phút", questions: 30 },
    { name: "Science Test", duration: "10 phút", questions: 30 },
  ];

    const achievements = [
        { name: "Mốc 1", progress: 2, total: 5, description: "Hoàn thành 5 bài kiểm tra" },
        { name: "Mốc 2", progress: 2, total: 10, description: "Hoàn thành 10 bài kiểm tra" },
        { name: "Mốc 3", progress: 2, total: 15, description: "Hoàn thành 15 bài kiểm tra" },
    ];

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
                          <div className="progress-bar"
                               style={{width: `${(achievement.progress / achievement.total) * 100}%`}}></div>
                      </div>
                      <p>{achievement.progress}/{achievement.total}</p>
                  </div>
              ))}
          </div>
      </div>


  );


}

export default App;
