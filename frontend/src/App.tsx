import { useState } from "react";
import TareasList from "./components/TareasList/TareasList";


function App() {
  const [open, setOpen] = useState(false);
  const [theme, setTheme] = useState("light");

  return (
    <div className={`${theme} min-h-screen text-slate-900 dark:bg-background dark:text-primary`}>
      <div className="flex items-center justify-between p-4">
        <div className="font-bold">Logo</div>

        {/*Desktop Nav*/}
        <div className="hidden sm:flex gap-5">
          <span>Home</span>
          <span>About</span>
          <span>Contact</span>
          <button className="text-2xl cursor-pointer" onClick={() => setTheme(theme === "light" ? "dark" : "light")}>{theme === "light" ? "🌙" : "☀️"}</button>
        </div>

        <button className="text-2xl cursor-pointer sm:hidden"  onClick={() => setOpen(!open)}>≡</button>

      </div>

      {/*Mobile Nav*/}
      {open && (
        <div className="flex flex-col items-center gap-5 text-slate-900 dark:bg-slate-900 dark:text-white font-bold">
          <span>Home</span>
          <span>About</span>
          <span>Contact</span>
          <button className="text-2xl cursor-pointer" onClick={() => setTheme(theme === "light" ? "dark" : "light")}>{theme === "light" ? "🌙" : "☀️"}</button>

        </div>
      )}

      <div className="grid sm:grid-cols-2 md:grid-cols-3 text-white dark:text-white p-6 gap-6 font-bold text-center text-2xl sm:text-sm">
        <div className="bg-slate-500 p-4 rounded hover:bg-slate-600 hover:scale-105 transition-all duration-300">Uno</div>
        <div className="bg-slate-500 p-4 rounded hover:bg-slate-600 hover:scale-105">Dos</div>
        <div className="bg-slate-500 p-4 rounded hover:bg-slate-600">Tres</div>
        <div className="bg-slate-500 p-4 rounded hover:bg-slate-600">Cuatro</div>
        <div className="bg-slate-500 p-4 rounded hover:bg-slate-600">Cinco</div>
        <div className="bg-slate-500 p-4 rounded hover:bg-slate-600">Seis</div>
      </div>
    </div>
  )
}

export default App
