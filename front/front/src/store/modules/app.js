const state = {
    audio:[],
    audioIndex:-1
}

const mutations = {
  SET_audio: (state, audio) => {
    state.audio = audio
  },
  SET_audioIndex: (state, audioIndex) => {
    state.audioIndex = audioIndex
  }
}

const actions = {
    setAudio({ commit }) {
      return new Promise(resolve => {
        commit('SET_audio', [])
        commit('SET_audioIndex', -1)
      })
    },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

